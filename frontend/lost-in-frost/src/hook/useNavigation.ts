import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import navigationStore from "@/store/navigationStore";

interface TabItem {
  name: string;
  content: string;
  link: string;
}

const defaultTab: TabItem[] = [
  { name: "Home", content: "홈", link: "/" },
  { name: "Notice", content: "공지사항", link: "/notice/list" },
  { name: "Ranking", content: "랭킹", link: "/ranking" },
  { name: "Record", content: "전적", link: "/record/search" },
  { name: "Shop", content: "상점", link: "/shop/costume" },
];

const userTab: TabItem[] = [
  { name: "Home", content: "홈", link: "/" },
  { name: "Notice", content: "공지사항", link: "/notice/list" },
  { name: "Ranking", content: "랭킹", link: "/ranking" },
  { name: "Record", content: "전적", link: "/record/search" },
  { name: "Shop", content: "상점", link: "/shop/costume" },
  { name: "Mypage", content: "마이페이지", link: "/mypage/info" },
];

const useNavigation = (): [
  any[],
  (event: React.MouseEvent<HTMLElement | SVGSVGElement>) => void
] => {
  const { currentTab, setCurrentTab } = navigationStore();

  const [tabList, setTabList] = useState<TabItem[]>(defaultTab);
  const navigate = useNavigate();

  useEffect(() => {
    if (localStorage.getItem("token")) {
      setTabList(userTab);
    } else {
      setTabList(defaultTab);
    }
  }, [localStorage.getItem("token")]);

  const onClickHandler = (event: React.MouseEvent<HTMLElement | SVGSVGElement>) => {
    if (event) {
      const id = (event.target as Element).id;
      console.log("id", id);
      tabList.map((tab, index) => {
        if (tab.name === id) {
          setCurrentTab(tab.name);
          navigate(tab.link);
          return;
        }
      });
    }
  };

  return [tabList, onClickHandler];
};

export default useNavigation;
