import { Route, Routes } from "react-router-dom";
import Home from "@/pages/home/Home";
import Notice from "@/pages/notice/Notice";
import Ranking from "@/pages/ranking/Ranking";
import Record from "@/pages/record/Record";
import Shop from "@/pages/shop/Shop";
import TossSuccess from "./pages/mypage/TossSuccess";
import Mypage from "./pages/mypage/Mypage";
import User from "./pages/user/User";
import ErrorPage from "./pages/error/ErrorPage";
import Spinner from "./component/molecules/common/Spinner";
import axiosInstance from "./apis/axiosInstance";
import { AxiosError, AxiosResponse, InternalAxiosRequestConfig } from "axios";
import { useEffect, useState } from "react";
import axiosStore from "./store/axiosStore";

const App = () => {
  const { requestCnt, setRequestCnt, plusCnt, minusCnt } = axiosStore();

  useEffect(() => {
    axiosInstance.interceptors.request.use(
      (config: InternalAxiosRequestConfig) => {
        const token = sessionStorage.getItem("token");
        if (token) {
          config.headers.Authorization = `Bearer ${token}`;
        }

        setTimeout(() => {
          plusCnt();
        }, 100);

        return config;
      },
      (error: AxiosError) => {
        minusCnt();

        return Promise.reject(error);
      }
    );

    axiosInstance.interceptors.response.use(
      (response: AxiosResponse) => {
        //const error = response.data.response.error;
        minusCnt();

        return response;
      },
      (error: AxiosError) => {
        minusCnt();

        if (error.response && error.response.status) {
          switch (error.response.status) {
            // case 400:
            //   location.href = "/error";
            //   return new Promise(() => {});
            //case 401:
            // location.href = "/user/logout";
            //return new Promise(() => {});
            // case 403:
            //   location.href = "/error";
            //   return new Promise(() => {});
            // case 404:
            //   location.href = "/error";
            //   return new Promise(() => {});
            default:
              return Promise.reject(error);
          }
        }

        return Promise.reject(error);
      }
    );
  }, []);

  return (
    <div className="App">
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/notice/*" element={<Notice />} />
        <Route path="/ranking" element={<Ranking />} />
        <Route path="/record/*" element={<Record />} />
        <Route path="/mypage/*" element={<Mypage />} />
        <Route path="/shop/*" element={<Shop />} />
        <Route path="/user/*" element={<User />} />
        <Route path="/toss-success" element={<TossSuccess />} />
        <Route path="/toss-fail" />
        <Route path="/error" element={<ErrorPage />} />
      </Routes>
      {requestCnt < 0 && <Spinner></Spinner>}
    </div>
  );
};

export default App;
