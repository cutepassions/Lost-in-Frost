<div align="center">

# ❄ Lost in Frost ❄

<img src="WEB_IMG/메인.gif" width="600" height="400"/>

</div>

### 🎮 서비스 소개

- 평범한 생존게임은 가라! 다양한 상호작용과 랜덤 카드 선택을 통한 효과를 챙겨 30분을 버텨라!
- [게임 관련 README](https://github.com/cutepassions/Lost-in-Frost/blob/351539809cfbd53b3a7a3395308d1746046fd734/GAME.md)

### 🙍🏻‍♂️ 팀원 소개

<div align="center">

<table align="center">
    <tr align="center">
        <td style="min-width: 150px;">
            <a href="https://github.com/imbeom35">
              <img src="https://avatars.githubusercontent.com/u/97426151?v=4" width="200">
              <br />
              <b>김범창</b>
            </a>
        </td>
        <td style="min-width: 150px;">
            <a href="https://github.com/cutepassions">
              <img src="https://avatars.githubusercontent.com/u/105566077?v=4" width="200">
              <br />
              <b>진병욱</b>
            </a>
        </td>
    </tr>
    <tr align="center">
        <td>
          김범창 [FE, 게임 런처]
        </td>
        <td>
          진병욱 [BE, CI/CD]
        </td>
    </tr>
</table>

</div>

### 📆 개발 기간
- 2023.10.09 ~ 11.17 (6주)

### 💻 사용 서버
- AWS Lightsail

### 💽 개발 환경 및 사용 기술
- Frontend
    - JavaScript, React.js
- Backend
    - Java, Spring Boot, Spring Cloud Gateway, Spring Cloud Config, Spring Batch, JPA, Querydsl
    - MySQL, Redis
    - Prometheus, Grafana
    - Nginx, Docker, Jenkins, AWS lightsail/S3
    - Git, Gitlab

### ⚙ 아키텍처

<img src="WEB_IMG/프로젝트_아키텍처.drawio (1).png" style="max-width=300px;" />

### 💶 ERD

<img src="ERD.png" />

### 🔎 기능 소개

<div align="center">

|                              회원가입 (폼 작성)                              |
| :--------------------------------------------------------------------------: |
| <img src="WEB_IMG/회원가입1.gif" alt="회원가입1"  width="400" height="400"/> |

|                                회원가입 (코드 인증)                                 |
| :---------------------------------------------------------------------------------: |
| <img src="WEB_IMG/회원가입2.gif" alt="이메일 코드 인증"  width="400" height="400"/> |

|                                   로그인                                    |
| :-------------------------------------------------------------------------: |
| <img src="WEB_IMG/로그인.gif" alt="일반 로그인"  width="400" height="400"/> |

|                                       소셜 로그인                                        |
| :--------------------------------------------------------------------------------------: |
| <img src="WEB_IMG/소셜로그인_모자이크.gif" alt="소셜 로그인"  width="400" height="400"/> |

|                                런처                                |
| :----------------------------------------------------------------: |
| <img src="WEB_IMG/런처.gif" alt="런처"  width="800" height="600"/> |

|                                  공지사항                                  |
| :------------------------------------------------------------------------: |
| <img src="WEB_IMG/공지사항.gif" alt="공지사항"  width="800" height="600"/> |

|                                랭킹                                |
| :----------------------------------------------------------------: |
| <img src="WEB_IMG/랭킹.gif" alt="랭킹"  width="800" height="600"/> |

|                                전적                                |
| :----------------------------------------------------------------: |
| <img src="WEB_IMG/전적.gif" alt="전적"  width="800" height="600"/> |

|                                상점                                |
| :----------------------------------------------------------------: |
| <img src="WEB_IMG/상점.gif" alt="상점"  width="800" height="600"/> |

|                                    크리스탈 결제                                     |
| :----------------------------------------------------------------------------------: |
| <img src="WEB_IMG/결제_모자이크.gif" alt="크리스탈 결제"  width="800" height="600"/> |

|                                   마이페이지                                   |
| :----------------------------------------------------------------------------: |
| <img src="WEB_IMG/마이페이지.gif" alt="마이페이지"  width="800" height="600"/> |

</div>


### 아쉬웠던 점
빠른 시간내에 비교적 적은 인원으로 프로젝트를 진행해야 하다 보니, 놓쳤던 부분들도 많았고, 사소한 부분들을 크게 신경쓰지 못했습니다.

추후에 시간을 따로 가져, 개인적으로 프로젝트를 리뷰하며 개선이 필요한 점들을 개선해 나갈 예정입니다.

### 개선 사항

#### 사용자 인증 구조 개선

- 관련 링크
  - 이슈 : [✔ FEATURE: Redis를 활용한 refresh token 관리 #7](https://github.com/cutepassions/Lost-in-Frost/issues/7)
  - 포스팅 : [Redis와 쿠키를 활용한 JWT 관리](https://velog.io/@cutepassions/series/Redis%EC%99%80-%EC%BF%A0%ED%82%A4%EB%A5%BC-%ED%99%9C%EC%9A%A9%ED%95%9C-JWT-%EA%B4%80%EB%A6%AC)