import styled from "styled-components";
import Navigation from "@/component/organisms/Navigation";
import HeaderImage from "@/component/organisms/HeaderImage";
import Body from "@/component/organisms/Body";
import Footer from "@/component/organisms/Footer";
import PageTitle from "@/component/organisms/PageTitle";
import ShopPannel from "@/component/molecules/shop/ShopPannel";
import { Route, Routes } from "react-router-dom";
import ShopCostume from "./ShopCostume";
import useShopPannel from "@/hook/useShopPannel";
import PaymentState from "@/component/molecules/mypage/payment/PaymentState";

const Shop = () => {
  const [tabList, currentTab, onclickHandler] = useShopPannel();

  return (
    <ShopContainer>
      <Navigation />
      <HeaderImage height={200} />
      <Body width={1200} topHeight={280}>
        <PageTitle text="상점" />
        {sessionStorage.getItem("token") && <PaymentState />}
        <ShopPannel tabList={tabList} currentTab={currentTab} onClickHandler={onclickHandler}>
          <Routes>
            <Route path="costume" element={<ShopCostume />} />
          </Routes>
        </ShopPannel>
      </Body>
      <Footer />
    </ShopContainer>
  );
};

const ShopContainer = styled.div`
  display: flex;
  flex-direction: column;
  margin: 0;
  padding: 0;
`;

export default Shop;
