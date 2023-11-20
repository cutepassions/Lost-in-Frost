import axios, { InternalAxiosRequestConfig, AxiosResponse, AxiosError } from "axios";
import { BASE_URL } from "@/constant/api";

https: const axiosInstance = axios.create({
  baseURL: BASE_URL,
  headers: { "Content-Type": "application/json" },
});

export default axiosInstance;
