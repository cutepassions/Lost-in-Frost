import { PostNoticeCommentWriteParams, postNoticeCommentWrite } from "@/apis/apiNotice";
import React, { useEffect, useState } from "react";

const useCommentWrite = (
  noticeSeq: number
): [
  boolean,
  string,
  () => Promise<boolean>,
  (event: React.ChangeEvent<HTMLTextAreaElement>) => void
] => {
  const [isLogin, setIsLogin] = useState(false);
  const [comment, setComment] = useState<string>("");

  useEffect(() => {
    const token = localStorage.getItem("token");
    console.log(token);
    if (token && token.length > 0) {
      setIsLogin(true);
    }
  }, []);

  const commentSubmit = async (): Promise<boolean> => {
    try {
      const noticeCommentWriteParams: PostNoticeCommentWriteParams = {
        noticeSeq: noticeSeq,
        content: comment,
      };
      const response = await postNoticeCommentWrite(noticeCommentWriteParams);
      if (response.data.success) {
        setComment("");
        return true;
      }
    } catch (err) {
      console.log(err);
    }
    return false;
  };

  const onChangeHandler = (event: React.ChangeEvent<HTMLTextAreaElement>) => {
    if (isLogin) {
      const value = event.target.value;
      if (value !== undefined) {
        setComment(value);
      }
    }
  };

  return [isLogin, comment, commentSubmit, onChangeHandler];
};

export default useCommentWrite;
