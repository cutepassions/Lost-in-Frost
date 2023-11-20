import styled from "styled-components";
import CustomInput from "@/component/atoms/input/CustomInput";
import SocialButton from "@/component/atoms/button/SocialButton";
import CustomButton from "@/component/atoms/button/CustomButton";
import MainLogo from "@/asset/logo/MainLogo.png";
import { useNavigate } from "react-router-dom";
import useLogin from "@/hook/useLogin";
import Spinner from "@/component/molecules/common/Spinner";

const UserLogin = () => {
  const navigate = useNavigate();

  const [values, messages, states, onSubmit, onChange, onKeyboard, setValues] = useLogin();

  return (
    <LoginContainer>
      <MainLogoStyle src={MainLogo} onClick={() => navigate("/")}></MainLogoStyle>
      <ItemWrapper>
        <CustomInput
          placeholder="Email"
          size="large"
          disabled={false}
          width={300}
          name="email"
          value={values.email}
          onChange={onChange}
        />
        <CustomInput
          type="password"
          placeholder="Password"
          size="large"
          disabled={false}
          width={300}
          name="password"
          value={values.password}
          onKeyDown={onKeyboard}
          onChange={onChange}
        />
        <CustomButton
          label="로그인"
          size="medium"
          color="black"
          style="default"
          width={"300px"}
          onClick={() => onSubmit()}
        />
        <Text>
          <TextItem onClick={() => navigate("/user/join")}>회원가입</TextItem>
          {"\u00A0|\u00A0"}
          <TextItem onClick={() => navigate("/")}>아이디 찾기</TextItem>
          {"\u00A0|\u00A0"}
          <TextItem onClick={() => navigate("/")}>비밀번호 찾기</TextItem>
        </Text>
      </ItemWrapper>
      <ItemWrapper>
        <SocialButton name="google"></SocialButton>
        <SocialButton name="kakao"></SocialButton>
        <SocialButton name="naver"></SocialButton>
      </ItemWrapper>
    </LoginContainer>
  );
};

const LoginContainer = styled.div`
  width: 300px;
  display: flex;
  align-items: center;
  flex-direction: column;
  box-sizing: border-box;

  > *:nth-child(n + 2) {
    margin-top: 20px;
  }
`;

const MainLogoStyle = styled.img`
  width: 200px;
  height: 200px;
  cursor: pointer;
`;

const ItemWrapper = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;

  > *:nth-child(n + 2) {
    margin-top: 5px;
  }
`;

const Text = styled.div`
  display: flex;
  justify-content: left;
  width: 300px;
  font-family: Pretendard;
  font-size: 12px;
  font-weight: 500;
`;

const TextItem = styled.div`
  cursor: pointer;
  &:hover {
    font-weight: bold;
  }
`;

export default UserLogin;
