import { getUserMyPageInfo } from "@/apis/apiUser";
import userStore from "@/store/userStore";
import { useEffect } from "react";
import { useNavigate, useSearchParams } from "react-router-dom";

const UserRedirect = () => {
  const {
    email,
    nickname,
    level,
    experience,
    crystal,
    coin,
    myCostumeSeq,
    costumeSeq,
    costumeName,
    costumeImage,
    costumeGrade,
    message,
    authProvider,
    gamePlayCount,
    successCount,
    setEmail,
    setNickname,
    setLevel,
    setExperience,
    setCrystal,
    setCoin,
    setMyCostumeSeq,
    setCostumeSeq,
    setCostumeName,
    setCostumeImage,
    setCostumeGrade,
    setMessage,
    setAuthProvider,
    setGamePlayCount,
    setSuccessCount,
    reset,
  } = userStore();

  const navigate = useNavigate();
  const [searchParams] = useSearchParams();
  const token = searchParams.get("token");

  const login = async () => {
    if (token) {
      localStorage.setItem("token", token);
    }
    navigate("/");
    // await new Promise(() => {
    //   setTimeout(() => {
    //     const token = searchParams.get("token");
    //     if (token) {
    //       sessionStorage.setItem("token", token);
    //     }
    //   }, 0);
    // });
    // try {
    //   const response = await getUserMyPageInfo();
    //   if (response.data.success) {
    //     const data = response.data.response;
    //     setEmail(data.email);
    //     setNickname(data.nickname);
    //     setLevel(data.level);
    //     setExperience(data.experience);
    //     setCrystal(data.crystal);
    //     setCoin(data.coin);
    //     setMyCostumeSeq(data.myCostumeSeq);
    //     setCostumeSeq(data.costumeSeq);
    //     setCostumeName(data.costumeName);
    //     setCostumeImage(data.costumeImage);
    //     setCostumeGrade(data.costumeGrade);
    //     setMessage(data.Message);
    //     setAuthProvider(data.authProvider);
    //     setGamePlayCount(data.gamePlayCount);
    //     setSuccessCount(data.successCount);
    //   }
    //   navigate("/");
    // } catch (err) {
    //   navigate("/");
    //   return;
    // }
  };

  // console.log(isLoggedIn);
  // if (isLoggedIn) {
  // } else {
  //   alert("로그인에 실패했습니다.");
  // }

  useEffect(() => {
    login();
  }, []);

  return <div></div>;
};

export default UserRedirect;
