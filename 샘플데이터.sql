-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.11.7-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- 테이블 jobbingsoo.application 구조 내보내기
CREATE TABLE IF NOT EXISTS `application` (
  `app_code` bigint(20) NOT NULL AUTO_INCREMENT,
  `result` varchar(255) DEFAULT NULL,
  `post_code` bigint(20) DEFAULT NULL,
  `rid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`app_code`),
  KEY `FKjdmct3qdcy5t0ycskg5vvpues` (`post_code`),
  KEY `FKqy0s5okmxw765vn4uhsmwj8a5` (`rid`),
  CONSTRAINT `FKjdmct3qdcy5t0ycskg5vvpues` FOREIGN KEY (`post_code`) REFERENCES `posting` (`post_code`),
  CONSTRAINT `FKqy0s5okmxw765vn4uhsmwj8a5` FOREIGN KEY (`rid`) REFERENCES `member` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 jobbingsoo.application:~0 rows (대략적) 내보내기
DELETE FROM `application`;

-- 테이블 jobbingsoo.career 구조 내보내기
CREATE TABLE IF NOT EXISTS `career` (
  `car_code` bigint(20) NOT NULL AUTO_INCREMENT,
  `car_date` date DEFAULT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `industry` varchar(255) DEFAULT NULL,
  `job` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `work` varchar(255) DEFAULT NULL,
  `resume_code` bigint(20) DEFAULT NULL,
  `rid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`car_code`),
  KEY `FK72moa9gig96wrf9a4g9uu1hc8` (`resume_code`),
  KEY `FK7s3en9tit18niyrcyhrcvsixf` (`rid`),
  CONSTRAINT `FK72moa9gig96wrf9a4g9uu1hc8` FOREIGN KEY (`resume_code`) REFERENCES `resume` (`resume_code`),
  CONSTRAINT `FK7s3en9tit18niyrcyhrcvsixf` FOREIGN KEY (`rid`) REFERENCES `member` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 jobbingsoo.career:~20 rows (대략적) 내보내기
DELETE FROM `career`;
INSERT INTO `career` (`car_code`, `car_date`, `company_name`, `end_date`, `industry`, `job`, `position`, `work`, `resume_code`, `rid`) VALUES
	(1, '2015-03-01', '삼성전자', '2020-05-31', '정보기술', '소프트웨어 엔지니어', '대리', '대규모 분산 시스템 개발 및 유지 보수', 1, 'user1'),
	(2, '2020-06-01', '네이버', '2023-04-30', '정보기술', '백엔드 개발자', '과장', '클라우드 서비스 백엔드 개발 및 최적화', 2, 'user1'),
	(3, '2017-08-01', 'LG전자', '2019-12-31', '디자인', 'UI/UX 디자이너', '사원', '모바일 앱 UI 디자인 및 사용자 경험 개선', 3, 'user2'),
	(4, '2020-01-01', '카카오', '2023-03-31', '디자인', '그래픽 디자이너', '주임', '브랜드 아이덴티티 디자인 및 시각 자료 제작', 4, 'user2'),
	(5, '2016-05-01', '현대자동차', '2020-10-31', '마케팅', '마케팅 매니저', '대리', '마케팅 전략 기획 및 실행, 시장 분석', 5, 'user3'),
	(6, '2021-01-01', '제일기획', '2023-04-30', '광고', '광고 기획자', '과장', '광고 캠페인 기획 및 운영, 광고 효과 분석', 6, 'user3'),
	(7, '2018-02-01', 'SK하이닉스', '2021-12-31', '데이터', '데이터 사이언티스트', '주임', '빅데이터 분석 및 머신러닝 모델 개발', 7, 'user4'),
	(8, '2022-01-01', '네이버', '2023-05-31', '데이터', '데이터 엔지니어', '차장', '데이터 파이프라인 설계 및 데이터베이스 관리', 8, 'user4'),
	(9, '2014-03-01', '한화테크윈', '2019-08-31', '기계', '기계 엔지니어', '대리', '산업용 로봇 설계 및 개발', 9, 'user5'),
	(10, '2019-09-01', 'LG전자', '2023-04-30', '기계', '기계 엔지니어', '수석', '가전제품 기계 부품 설계 및 성능 개선', 10, 'user5'),
	(11, '2017-06-01', 'CJ ENM', '2020-11-30', '콘텐츠', '콘텐츠 크리에이터', '사원', '영상 콘텐츠 기획 및 제작, 편집', 11, 'user6'),
	(12, '2021-01-01', 'SBS', '2023-03-31', '콘텐츠', '프로듀서', '팀장', '방송 프로그램 기획 및 제작, 제작진 관리', 12, 'user6'),
	(13, '2015-09-01', '카카오', '2020-04-30', '정보기술', '웹 개발자', '주임', '웹 애플리케이션 개발 및 유지 보수', 13, 'user7'),
	(14, '2020-05-01', '라인', '2023-03-31', '정보기술', '프론트엔드 개발자', '과장', '모바일 앱 프론트엔드 개발 및 UI 개선', 14, 'user7'),
	(15, '2018-07-01', '삼성전자', '2020-12-31', '경영', '프로젝트 매니저', '대리', '프로젝트 기획 및 운영, 팀 관리', 15, 'user8'),
	(16, '2021-01-01', '현대자동차', '2023-05-31', '경영', '경영 컨설턴트', '차장', '경영 전략 수립 및 실행, 경영 컨설팅', 16, 'user8'),
	(17, '2016-03-01', 'LG화학', '2020-06-30', '데이터', '데이터 분석가', '주임', '데이터 분석 및 시각화, 보고서 작성', 17, 'user9'),
	(18, '2020-07-01', '네이버', '2023-04-30', '비즈니스', '비즈니스 분석가', '과장', '비즈니스 데이터 분석 및 전략 수립', 18, 'user9'),
	(19, '2019-01-01', '한샘', '2020-12-31', '디자인', '그래픽 디자이너', '사원', '인테리어 디자인 및 그래픽 디자인', 19, 'user10'),
	(20, '2021-01-01', 'LG하우시스', '2023-03-31', '디자인', '브랜드 디자이너', '수석', '브랜드 아이덴티티 개발 및 디자인 프로젝트 관리', 20, 'user10');

-- 테이블 jobbingsoo.certificate 구조 내보내기
CREATE TABLE IF NOT EXISTS `certificate` (
  `certi_code` bigint(20) NOT NULL AUTO_INCREMENT,
  `issuer` varchar(255) DEFAULT NULL,
  `optain_date` date DEFAULT NULL,
  `stack` varchar(255) DEFAULT NULL,
  `resume_code` bigint(20) DEFAULT NULL,
  `rid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`certi_code`),
  KEY `FK4w2h9j1gc6v79cung2ql8ibeo` (`resume_code`),
  KEY `FK2vtsy4gl6k0i31p94r92lq4op` (`rid`),
  CONSTRAINT `FK2vtsy4gl6k0i31p94r92lq4op` FOREIGN KEY (`rid`) REFERENCES `member` (`username`),
  CONSTRAINT `FK4w2h9j1gc6v79cung2ql8ibeo` FOREIGN KEY (`resume_code`) REFERENCES `resume` (`resume_code`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 jobbingsoo.certificate:~40 rows (대략적) 내보내기
DELETE FROM `certificate`;
INSERT INTO `certificate` (`certi_code`, `issuer`, `optain_date`, `stack`, `resume_code`, `rid`) VALUES
	(1, '한국산업인력공단', '2016-05-20', '정보처리기사', 1, 'user1'),
	(2, 'Amazon Web Services', '2018-11-15', 'AWS Certified Solutions Architect', 1, 'user1'),
	(3, 'Oracle', '2017-08-10', 'OCJP', 2, 'user1'),
	(4, 'Cloud Native Computing Foundation', '2020-02-28', 'Kubernetes Administrator', 2, 'user1'),
	(5, 'Adobe', '2018-06-12', 'Adobe Certified Expert (ACE)', 3, 'user2'),
	(6, 'Interaction Design Foundation', '2019-09-22', 'Certified UX Designer', 3, 'user2'),
	(7, 'Google', '2020-07-05', 'Google UX Design Professional Certificate', 4, 'user2'),
	(8, 'Adobe', '2017-03-18', 'Adobe Certified Associate (ACA)', 4, 'user2'),
	(9, 'Google', '2017-11-30', 'Google Analytics Individual Qualification', 5, 'user3'),
	(10, 'Digital Marketing Institute', '2019-04-14', 'Certified Digital Marketing Professional', 5, 'user3'),
	(11, 'Facebook', '2020-08-25', 'Facebook Blueprint Certification', 6, 'user3'),
	(12, 'HubSpot', '2018-12-10', 'HubSpot Content Marketing Certification', 6, 'user3'),
	(13, 'Microsoft', '2019-10-19', 'Microsoft Certified: Azure Data Scientist Associate', 7, 'user4'),
	(14, 'Institute for Certification of Computing Professionals', '2018-05-22', 'Certified Data Professional (CDP)', 7, 'user4'),
	(15, 'Google', '2021-03-11', 'Google Professional Data Engineer', 8, 'user4'),
	(16, 'Cloudera', '2017-09-30', 'Cloudera Certified Data Scientist', 8, 'user4'),
	(17, '한국산업인력공단', '2015-07-15', '기계설계기사', 9, 'user5'),
	(18, 'Autodesk', '2018-02-20', 'CAD Technician Certification', 9, 'user5'),
	(19, 'Dassault Systèmes', '2019-05-05', 'Certified SolidWorks Professional (CSWP)', 10, 'user5'),
	(20, '한국산업인력공단', '2020-10-25', '기계정비산업기사', 10, 'user5'),
	(21, 'Adobe', '2018-11-02', 'Adobe Certified Professional in Video Design', 11, 'user6'),
	(22, 'Apple', '2019-08-17', 'Apple Certified Pro - Final Cut Pro X', 11, 'user6'),
	(23, 'Society of Broadcast Engineers', '2020-01-29', 'Certified Broadcast Networking Technologist (CBNT)', 12, 'user6'),
	(24, 'Society of Broadcast Engineers', '2017-04-11', 'Certified Video Engineer (CEV)', 12, 'user6'),
	(25, 'International Web Association', '2016-06-28', 'Certified Web Professional - Web Developer', 13, 'user7'),
	(26, 'Microsoft', '2018-03-15', 'Microsoft Certified: Azure Developer Associate', 13, 'user7'),
	(27, 'W3Schools', '2019-07-23', 'Certified JavaScript Developer', 14, 'user7'),
	(28, 'Udacity', '2020-11-08', 'React Professional Certification', 14, 'user7'),
	(29, 'Project Management Institute', '2017-09-18', 'Project Management Professional (PMP)', 15, 'user8'),
	(30, 'Scrum Alliance', '2018-12-22', 'Certified ScrumMaster (CSM)', 15, 'user8'),
	(31, 'American Society for Quality', '2019-05-30', 'Six Sigma Black Belt', 16, 'user8'),
	(32, 'International Institute of Business Analysis', '2020-04-14', 'Business Analysis Professional (CBAP)', 16, 'user8'),
	(33, 'Data Management Association International', '2017-08-21', 'Certified Data Management Professional (CDMP)', 17, 'user9'),
	(34, 'Microsoft', '2019-11-05', 'Microsoft Certified: Data Analyst Associate', 17, 'user9'),
	(35, 'Tableau', '2020-06-18', 'Tableau Desktop Specialist', 18, 'user9'),
	(36, 'Institute for Operations Research and the Management Sciences', '2018-01-27', 'Certified Analytics Professional (CAP)', 18, 'user9'),
	(37, 'Adobe', '2019-04-10', 'Adobe Certified Expert (ACE)', 19, 'user10'),
	(38, 'Autodesk', '2017-12-12', 'Autodesk Certified Professional: AutoCAD', 19, 'user10'),
	(39, 'NCIDQ', '2020-02-29', 'Certified Interior Designer', 20, 'user10'),
	(40, 'Society of Graphic Designers of Canada', '2018-07-22', 'Certified Graphic Designer (CGD)', 20, 'user10');

-- 테이블 jobbingsoo.company 구조 내보내기
CREATE TABLE IF NOT EXISTS `company` (
  `cno` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `ceo` varchar(255) DEFAULT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `manager_email` varchar(255) DEFAULT NULL,
  `manager_name` varchar(255) DEFAULT NULL,
  `manager_tel` varchar(255) DEFAULT NULL,
  `sales` int(11) DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `cid` varchar(255) DEFAULT NULL,
  `sccode` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`cno`),
  KEY `FKp75n2vacbkqbuuduokktysnok` (`cid`),
  KEY `FKdvurwrr7s2pakjt9dluw4c1g6` (`sccode`),
  CONSTRAINT `FKdvurwrr7s2pakjt9dluw4c1g6` FOREIGN KEY (`sccode`) REFERENCES `sub_category` (`sccode`),
  CONSTRAINT `FKp75n2vacbkqbuuduokktysnok` FOREIGN KEY (`cid`) REFERENCES `member` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 jobbingsoo.company:~10 rows (대략적) 내보내기
DELETE FROM `company`;
INSERT INTO `company` (`cno`, `address`, `ceo`, `company_name`, `manager_email`, `manager_name`, `manager_tel`, `sales`, `size`, `tel`, `cid`, `sccode`) VALUES
	('1', '서울특별시 강남구 테헤란로 123', '김철수', '삼성전자', 'user11@example.com', NULL, '010-1234-5678', 1000000, '150', '02-1234-5678', 'user11', 1),
	('10', '충청북도 청주시 상당구 상당로 707', '유민호', '셀트리온', 'user20@example.com', NULL, '010-0123-4567', 10000000, '500', '043-0123-4567', 'user20', 83),
	('2', '부산광역시 해운대구 우동 456', '박영희', 'LG전자', 'user12@example.com', NULL, '010-2345-6789', 2000000, '300', '051-2345-6789', 'user12', 10),
	('3', '대구광역시 중구 동성로 789', '이민수', '현대자동차', 'user13@example.com', NULL, '010-3456-7890', 3000000, '200', '053-3456-7890', 'user13', 20),
	('4', '인천광역시 남동구 구월로 101', '최지우', 'SK하이닉스', 'user14@example.com', NULL, '010-4567-8901', 4000000, '250', '032-4567-8901', 'user14', 30),
	('5', '광주광역시 서구 풍암로 202', '강준수', '네이버', 'user15@example.com', NULL, '010-5678-9012', 5000000, '350', '062-5678-9012', 'user15', 40),
	('6', '대전광역시 유성구 도룡로 303', '한지민', '카카오', 'user16@example.com', NULL, '010-6789-0123', 6000000, '100', '042-6789-0123', 'user16', 50),
	('7', '울산광역시 남구 삼산로 404', '조윤호', '포스코', 'user17@example.com', NULL, '010-7890-1234', 7000000, '450', '052-7890-1234', 'user17', 60),
	('8', '세종특별자치시 한누리대로 505', '서연희', '한국전력', 'user18@example.com', NULL, '010-8901-2345', 8000000, '400', '044-8901-2345', 'user18', 70),
	('9', '경기도 성남시 분당구 판교로 606', '이승기', '현대모비스', 'user19@example.com', NULL, '010-9012-3456', 9000000, '300', '031-9012-3456', 'user19', 80);

-- 테이블 jobbingsoo.cover_letter 구조 내보내기
CREATE TABLE IF NOT EXISTS `cover_letter` (
  `cl_code` bigint(20) NOT NULL AUTO_INCREMENT,
  `jangdanzeum` varchar(255) DEFAULT NULL,
  `juwondongki` varchar(255) DEFAULT NULL,
  `sungjang` varchar(255) DEFAULT NULL,
  `resume_code` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`cl_code`),
  KEY `FK9fe8ipml1q80bcayekxoo014x` (`resume_code`),
  CONSTRAINT `FK9fe8ipml1q80bcayekxoo014x` FOREIGN KEY (`resume_code`) REFERENCES `resume` (`resume_code`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 jobbingsoo.cover_letter:~20 rows (대략적) 내보내기
DELETE FROM `cover_letter`;
INSERT INTO `cover_letter` (`cl_code`, `jangdanzeum`, `juwondongki`, `sungjang`, `resume_code`) VALUES
	(1, '저는 성실하고 책임감이 강한 성격을 가지고 있습니다. 팀원들과 협력하여 프로젝트를 성공적으로 완료하는 경험이 많으며, 리더십을 발휘해 팀을 이끄는 역할도 종종 맡았습니다. 하지만 때로는 너무 완벽을 추구하는 경향이 있어 스트레스를 받기도 합니다. 이를 극복하기 위해 유연한 사고와 상황 대처 능력을 기르기 위해 노력하고 있습니다.', '저는 항상 소프트웨어 개발에 대한 열정을 가지고 있었습니다. 특히, 삼성전자의 혁신적인 기술과 글로벌 시장에서의 영향력을 보며 큰 영감을 받았습니다. 이러한 회사에서 제 능력을 발휘하고 싶다는 생각에 지원하게 되었습니다. 또한, 삼성전자가 추구하는 비전과 가치가 저의 목표와 일치하기 때문에 이 회사에서 성장할 수 있을 것이라 확신합니다.', '저는 어렸을 때부터 호기심이 많고 탐구심이 강한 아이였습니다. 항상 새로운 것을 배우고 경험하는 것을 좋아했고, 이러한 성향은 제가 학업과 직업 선택에 있어서 큰 영향을 미쳤습니다. 대학 시절에는 컴퓨터 공학을 전공하며 다양한 프로젝트와 연구를 통해 실력을 쌓았고, 그 과정에서 문제 해결 능력과 창의적인 사고를 키울 수 있었습니다.', 1),
	(2, '저는 창의적이고 열정적인 성격을 가지고 있습니다. 새로운 아이디어를 제안하고 이를 실현하는 과정에서 큰 만족감을 느낍니다. 하지만 가끔은 세부 사항에 지나치게 집착하는 경향이 있어 시간 관리를 잘 해야 합니다. 이를 보완하기 위해 우선순위를 정하고 효율적으로 일하려고 노력하고 있습니다.', 'LG전자는 혁신적인 디자인과 기술력으로 유명한 회사입니다. 저는 이러한 환경에서 제 디자인 역량을 최대한 발휘하고 싶어 지원하게 되었습니다. LG전자의 디자인 철학과 제품이 사용자에게 미치는 긍정적인 영향을 보며 큰 감명을 받았고, 이러한 회사에서 일하며 성장하고 싶습니다.', '예술적인 환경에서 자라난 저는 항상 창의적인 표현에 관심이 많았습니다. 어렸을 때부터 그림 그리기와 디자인에 흥미를 느껴 왔고, 이를 발전시키기 위해 꾸준히 노력해왔습니다. 대학에서는 시각디자인을 전공하며 다양한 프로젝트를 수행하며 디자인 감각과 기술을 연마했습니다.', 2),
	(3, '저는 분석적이고 전략적인 사고를 가지고 있습니다. 데이터를 기반으로 한 문제 해결을 좋아하며, 팀과 협력하여 목표를 달성하는 데 큰 보람을 느낍니다. 하지만 때로는 너무 세부적인 부분에 집중하는 경향이 있어 전체적인 그림을 놓칠 때가 있습니다. 이를 보완하기 위해 큰 틀에서 생각하고, 중요한 사항에 집중하려고 노력하고 있습니다.', '현대자동차의 마케팅 전략과 글로벌 시장에서의 성공 사례를 보며 큰 감명을 받았습니다. 특히, 현대자동차가 추구하는 혁신과 도전 정신이 저의 가치관과 잘 맞아 이 회사에서 일하고 싶다는 생각이 들었습니다. 저의 마케팅 역량을 현대자동차에서 발휘하고, 함께 성장하고 싶어 지원하게 되었습니다.', '경영자이신 부모님 아래에서 자란 저는 어렸을 때부터 비즈니스와 관련된 많은 경험을 할 수 있었습니다. 부모님의 가게를 도우며 자연스럽게 경영과 마케팅에 관심을 갖게 되었고, 이러한 경험은 제 경력 선택에 큰 영향을 미쳤습니다. 대학에서는 경영학을 전공하며 이론과 실무를 겸비한 전문가로 성장하고자 노력했습니다.', 3),
	(4, '저는 분석적이고 논리적인 성격을 가지고 있습니다. 데이터를 통해 문제를 해결하는 과정에서 큰 만족감을 느끼며, 항상 최선의 결과를 도출하기 위해 노력합니다. 하지만 가끔은 너무 데이터에만 의존하는 경향이 있어 창의적인 사고를 놓칠 때가 있습니다. 이를 보완하기 위해 다양한 관점에서 문제를 바라보고, 창의적인 해결책을 찾으려고 노력하고 있습니다.', '연세대학교에서의 연구 경험을 통해 데이터의 중요성을 깨닫게 되었습니다. SK하이닉스는 데이터 기반의 의사결정과 혁신을 추구하는 회사로, 저의 역량을 발휘하기에 최적의 장소라고 생각했습니다. 특히, SK하이닉스의 글로벌 영향력과 지속 가능한 발전에 기여하고 싶어 지원하게 되었습니다.', '저는 과학과 수학에 대한 열정이 강한 학생이었습니다. 학교에서는 항상 높은 성적을 유지하며 다양한 과학 경진대회에서 수상한 경험이 있습니다. 이러한 경험은 저의 문제 해결 능력을 키워주었고, 대학에서는 통계학을 전공하며 데이터를 분석하고 해석하는 능력을 더욱 발전시킬 수 있었습니다.', 4),
	(5, '저는 논리적이고 체계적인 성격을 가지고 있습니다. 프로젝트를 계획하고 실행하는 과정에서 항상 효율성을 추구하며, 팀과 협력하여 목표를 달성하는 데 큰 보람을 느낍니다. 하지만 가끔은 너무 세부 사항에 집착하는 경향이 있어 전체적인 그림을 놓칠 때가 있습니다. 이를 보완하기 위해 큰 틀에서 생각하고, 중요한 사항에 집중하려고 노력하고 있습니다.', '한양대학교에서의 학업과 연구를 통해 기계공학에 대한 깊은 이해를 가지게 되었습니다. 네이버는 혁신적인 기술과 도전 정신으로 유명한 회사로, 저의 기술적 역량을 발휘하기에 최적의 장소라고 생각했습니다. 특히, 네이버의 글로벌 기술 개발에 기여하고 싶어 지원하게 되었습니다.', '저는 기계와 엔지니어링에 대한 관심이 어렸을 때부터 있었습니다. 부모님께서 운영하시는 작은 공장에서 다양한 기계들을 접할 수 있었고, 이는 저의 호기심을 자극했습니다. 대학에서는 기계공학을 전공하며 이론과 실습을 통해 실력을 쌓았고, 다양한 프로젝트를 수행하며 실무 능력을 키웠습니다.', 5),
	(6, '저는 창의적이고 열정적인 성격을 가지고 있습니다. 새로운 아이디어를 제안하고 이를 실현하는 과정에서 큰 만족감을 느낍니다. 하지만 가끔은 세부 사항에 지나치게 집착하는 경향이 있어 시간 관리를 잘 해야 합니다. 이를 보완하기 위해 우선순위를 정하고 효율적으로 일하려고 노력하고 있습니다.', '중앙대학교에서의 학업과 실습을 통해 콘텐츠 크리에이션에 대한 깊은 이해를 가지게 되었습니다. 카카오는 혁신적인 콘텐츠와 기술력으로 유명한 회사로, 저의 창의적 역량을 발휘하기에 최적의 장소라고 생각했습니다. 특히, 카카오의 다양한 콘텐츠 제작에 기여하고 싶어 지원하게 되었습니다.', '저는 예술과 창작에 대한 열정을 가지고 성장했습니다. 어렸을 때부터 그림 그리기와 글쓰기를 좋아했고, 이러한 관심은 저의 학업과 경력 선택에 큰 영향을 미쳤습니다. 대학에서는 영화학을 전공하며 다양한 프로젝트를 수행했고, 이를 통해 창의력과 표현력을 키울 수 있었습니다.', 6),
	(7, '저는 분석적이고 논리적인 성격을 가지고 있습니다. 소프트웨어를 통해 문제를 해결하는 과정에서 큰 만족감을 느끼며, 항상 최선의 결과를 도출하기 위해 노력합니다. 하지만 가끔은 너무 기술에만 의존하는 경향이 있어 창의적인 사고를 놓칠 때가 있습니다. 이를 보완하기 위해 다양한 관점에서 문제를 바라보고, 창의적인 해결책을 찾으려고 노력하고 있습니다.', '서강대학교에서의 연구 경험을 통해 소프트웨어 개발의 중요성을 깨닫게 되었습니다. 포스코는 혁신적인 기술과 글로벌 영향력으로 유명한 회사로, 저의 역량을 발휘하기에 최적의 장소라고 생각했습니다. 특히, 포스코의 글로벌 기술 개발에 기여하고 싶어 지원하게 되었습니다.', '저는 컴퓨터와 프로그래밍에 대한 열정이 강한 학생이었습니다. 학교에서는 항상 높은 성적을 유지하며 다양한 프로그래밍 대회에서 수상한 경험이 있습니다. 이러한 경험은 저의 문제 해결 능력을 키워주었고, 대학에서는 컴퓨터공학을 전공하며 소프트웨어 개발 능력을 더욱 발전시킬 수 있었습니다.', 7),
	(8, '저는 분석적이고 전략적인 사고를 가지고 있습니다. 데이터를 기반으로 한 문제 해결을 좋아하며, 팀과 협력하여 목표를 달성하는 데 큰 보람을 느낍니다. 하지만 때로는 너무 세부적인 부분에 집중하는 경향이 있어 전체적인 그림을 놓칠 때가 있습니다. 이를 보완하기 위해 큰 틀에서 생각하고, 중요한 사항에 집중하려고 노력하고 있습니다.', '이화여자대학교에서의 학업과 연구를 통해 경영에 대한 깊은 이해를 가지게 되었습니다. 한국전력은 혁신적인 경영 전략과 글로벌 시장에서의 성공 사례로 유명한 회사로, 저의 역량을 발휘하기에 최적의 장소라고 생각했습니다. 특히, 한국전력의 글로벌 경영에 기여하고 싶어 지원하게 되었습니다.', '저는 경영과 리더십에 대한 관심이 어렸을 때부터 있었습니다. 부모님께서 운영하시는 작은 가게에서 일을 도우며 자연스럽게 경영에 관심을 갖게 되었고, 이는 저의 학업과 경력 선택에 큰 영향을 미쳤습니다. 대학에서는 경영학을 전공하며 이론과 실무를 겸비한 전문가로 성장하고자 노력했습니다.', 8),
	(9, '저는 분석적이고 논리적인 성격을 가지고 있습니다. 데이터를 통해 문제를 해결하는 과정에서 큰 만족감을 느끼며, 항상 최선의 결과를 도출하기 위해 노력합니다. 하지만 가끔은 너무 데이터에만 의존하는 경향이 있어 창의적인 사고를 놓칠 때가 있습니다. 이를 보완하기 위해 다양한 관점에서 문제를 바라보고, 창의적인 해결책을 찾으려고 노력하고 있습니다.', '서울과학기술대학교에서의 연구 경험을 통해 데이터의 중요성을 깨닫게 되었습니다. 현대모비스는 데이터 기반의 의사결정과 혁신을 추구하는 회사로, 저의 역량을 발휘하기에 최적의 장소라고 생각했습니다. 특히, 현대모비스의 글로벌 영향력과 지속 가능한 발전에 기여하고 싶어 지원하게 되었습니다.', '저는 과학과 기술에 대한 열정이 강한 학생이었습니다. 학교에서는 항상 높은 성적을 유지하며 다양한 과학 경진대회에서 수상한 경험이 있습니다. 이러한 경험은 저의 문제 해결 능력을 키워주었고, 대학에서는 산업공학을 전공하며 데이터를 분석하고 해석하는 능력을 더욱 발전시킬 수 있었습니다.', 9),
	(10, '저는 창의적이고 열정적인 성격을 가지고 있습니다. 새로운 아이디어를 제안하고 이를 실현하는 과정에서 큰 만족감을 느낍니다. 하지만 가끔은 세부 사항에 지나치게 집착하는 경향이 있어 시간 관리를 잘 해야 합니다. 이를 보완하기 위해 우선순위를 정하고 효율적으로 일하려고 노력하고 있습니다.', '경희대학교에서의 학업과 실습을 통해 시각디자인에 대한 깊은 이해를 가지게 되었습니다. 셀트리온은 혁신적인 디자인과 기술력으로 유명한 회사로, 저의 창의적 역량을 발휘하기에 최적의 장소라고 생각했습니다. 특히, 셀트리온의 다양한 디자인 프로젝트에 기여하고 싶어 지원하게 되었습니다.', '저는 예술과 디자인에 대한 열정을 가지고 성장했습니다. 어렸을 때부터 그림 그리기와 디자인에 흥미를 느꼈고, 이러한 관심은 저의 학업과 경력 선택에 큰 영향을 미쳤습니다. 대학에서는 시각디자인을 전공하며 다양한 프로젝트를 수행했고, 이를 통해 디자인 감각과 기술을 연마할 수 있었습니다.', 10),
	(11, '저는 창의적이고 열정적인 성격을 가지고 있습니다. 새로운 아이디어를 제안하고 이를 실현하는 과정에서 큰 만족감을 느낍니다. 하지만 가끔은 세부 사항에 지나치게 집착하는 경향이 있어 시간 관리를 잘 해야 합니다. 이를 보완하기 위해 우선순위를 정하고 효율적으로 일하려고 노력하고 있습니다.', '중앙대학교에서의 학업과 실습을 통해 콘텐츠 크리에이션에 대한 깊은 이해를 가지게 되었습니다. 카카오는 혁신적인 콘텐츠와 기술력으로 유명한 회사로, 저의 창의적 역량을 발휘하기에 최적의 장소라고 생각했습니다. 특히, 카카오의 다양한 콘텐츠 제작에 기여하고 싶어 지원하게 되었습니다.', '저는 예술과 창작에 대한 열정을 가지고 성장했습니다. 어렸을 때부터 그림 그리기와 글쓰기를 좋아했고, 이러한 관심은 저의 학업과 경력 선택에 큰 영향을 미쳤습니다. 대학에서는 영화학을 전공하며 다양한 프로젝트를 수행했고, 이를 통해 창의력과 표현력을 키울 수 있었습니다.', 11),
	(12, '저는 분석적이고 논리적인 성격을 가지고 있습니다. 데이터를 통해 문제를 해결하는 과정에서 큰 만족감을 느끼며, 항상 최선의 결과를 도출하기 위해 노력합니다. 하지만 가끔은 너무 데이터에만 의존하는 경향이 있어 창의적인 사고를 놓칠 때가 있습니다. 이를 보완하기 위해 다양한 관점에서 문제를 바라보고, 창의적인 해결책을 찾으려고 노력하고 있습니다.', '연세대학교에서의 연구 경험을 통해 데이터의 중요성을 깨닫게 되었습니다. SK하이닉스는 데이터 기반의 의사결정과 혁신을 추구하는 회사로, 저의 역량을 발휘하기에 최적의 장소라고 생각했습니다. 특히, SK하이닉스의 글로벌 영향력과 지속 가능한 발전에 기여하고 싶어 지원하게 되었습니다.', '저는 과학과 수학에 대한 열정이 강한 학생이었습니다. 학교에서는 항상 높은 성적을 유지하며 다양한 과학 경진대회에서 수상한 경험이 있습니다. 이러한 경험은 저의 문제 해결 능력을 키워주었고, 대학에서는 통계학을 전공하며 데이터를 분석하고 해석하는 능력을 더욱 발전시킬 수 있었습니다.', 12),
	(13, '저는 논리적이고 체계적인 성격을 가지고 있습니다. 프로젝트를 계획하고 실행하는 과정에서 항상 효율성을 추구하며, 팀과 협력하여 목표를 달성하는 데 큰 보람을 느낍니다. 하지만 가끔은 너무 세부 사항에 집착하는 경향이 있어 전체적인 그림을 놓칠 때가 있습니다. 이를 보완하기 위해 큰 틀에서 생각하고, 중요한 사항에 집중하려고 노력하고 있습니다.', '한양대학교에서의 학업과 연구를 통해 기계공학에 대한 깊은 이해를 가지게 되었습니다. 네이버는 혁신적인 기술과 도전 정신으로 유명한 회사로, 저의 기술적 역량을 발휘하기에 최적의 장소라고 생각했습니다. 특히, 네이버의 글로벌 기술 개발에 기여하고 싶어 지원하게 되었습니다.', '저는 기계와 엔지니어링에 대한 관심이 어렸을 때부터 있었습니다. 부모님께서 운영하시는 작은 공장에서 다양한 기계들을 접할 수 있었고, 이는 저의 호기심을 자극했습니다. 대학에서는 기계공학을 전공하며 이론과 실습을 통해 실력을 쌓았고, 다양한 프로젝트를 수행하며 실무 능력을 키웠습니다.', 13),
	(14, '저는 분석적이고 논리적인 성격을 가지고 있습니다. 소프트웨어를 통해 문제를 해결하는 과정에서 큰 만족감을 느끼며, 항상 최선의 결과를 도출하기 위해 노력합니다. 하지만 가끔은 너무 기술에만 의존하는 경향이 있어 창의적인 사고를 놓칠 때가 있습니다. 이를 보완하기 위해 다양한 관점에서 문제를 바라보고, 창의적인 해결책을 찾으려고 노력하고 있습니다.', '서강대학교에서의 연구 경험을 통해 소프트웨어 개발의 중요성을 깨닫게 되었습니다. 포스코는 혁신적인 기술과 글로벌 영향력으로 유명한 회사로, 저의 역량을 발휘하기에 최적의 장소라고 생각했습니다. 특히, 포스코의 글로벌 기술 개발에 기여하고 싶어 지원하게 되었습니다.', '저는 컴퓨터와 프로그래밍에 대한 열정이 강한 학생이었습니다. 학교에서는 항상 높은 성적을 유지하며 다양한 프로그래밍 대회에서 수상한 경험이 있습니다. 이러한 경험은 저의 문제 해결 능력을 키워주었고, 대학에서는 컴퓨터공학을 전공하며 소프트웨어 개발 능력을 더욱 발전시킬 수 있었습니다.', 14),
	(15, '저는 분석적이고 전략적인 사고를 가지고 있습니다. 데이터를 기반으로 한 문제 해결을 좋아하며, 팀과 협력하여 목표를 달성하는 데 큰 보람을 느낍니다. 하지만 때로는 너무 세부적인 부분에 집중하는 경향이 있어 전체적인 그림을 놓칠 때가 있습니다. 이를 보완하기 위해 큰 틀에서 생각하고, 중요한 사항에 집중하려고 노력하고 있습니다.', '이화여자대학교에서의 학업과 연구를 통해 경영에 대한 깊은 이해를 가지게 되었습니다. 한국전력은 혁신적인 경영 전략과 글로벌 시장에서의 성공 사례로 유명한 회사로, 저의 역량을 발휘하기에 최적의 장소라고 생각했습니다. 특히, 한국전력의 글로벌 경영에 기여하고 싶어 지원하게 되었습니다.', '저는 경영과 리더십에 대한 관심이 어렸을 때부터 있었습니다. 부모님께서 운영하시는 작은 가게에서 일을 도우며 자연스럽게 경영에 관심을 갖게 되었고, 이는 저의 학업과 경력 선택에 큰 영향을 미쳤습니다. 대학에서는 경영학을 전공하며 이론과 실무를 겸비한 전문가로 성장하고자 노력했습니다.', 15),
	(16, '저는 분석적이고 논리적인 성격을 가지고 있습니다. 데이터를 통해 문제를 해결하는 과정에서 큰 만족감을 느끼며, 항상 최선의 결과를 도출하기 위해 노력합니다. 하지만 가끔은 너무 데이터에만 의존하는 경향이 있어 창의적인 사고를 놓칠 때가 있습니다. 이를 보완하기 위해 다양한 관점에서 문제를 바라보고, 창의적인 해결책을 찾으려고 노력하고 있습니다.', '서울과학기술대학교에서의 연구 경험을 통해 데이터의 중요성을 깨닫게 되었습니다. 현대모비스는 데이터 기반의 의사결정과 혁신을 추구하는 회사로, 저의 역량을 발휘하기에 최적의 장소라고 생각했습니다. 특히, 현대모비스의 글로벌 영향력과 지속 가능한 발전에 기여하고 싶어 지원하게 되었습니다.', '저는 과학과 기술에 대한 열정이 강한 학생이었습니다. 학교에서는 항상 높은 성적을 유지하며 다양한 과학 경진대회에서 수상한 경험이 있습니다. 이러한 경험은 저의 문제 해결 능력을 키워주었고, 대학에서는 산업공학을 전공하며 데이터를 분석하고 해석하는 능력을 더욱 발전시킬 수 있었습니다.', 16),
	(17, '저는 창의적이고 열정적인 성격을 가지고 있습니다. 새로운 아이디어를 제안하고 이를 실현하는 과정에서 큰 만족감을 느낍니다. 하지만 가끔은 세부 사항에 지나치게 집착하는 경향이 있어 시간 관리를 잘 해야 합니다. 이를 보완하기 위해 우선순위를 정하고 효율적으로 일하려고 노력하고 있습니다.', '경희대학교에서의 학업과 실습을 통해 시각디자인에 대한 깊은 이해를 가지게 되었습니다. 셀트리온은 혁신적인 디자인과 기술력으로 유명한 회사로, 저의 창의적 역량을 발휘하기에 최적의 장소라고 생각했습니다. 특히, 셀트리온의 다양한 디자인 프로젝트에 기여하고 싶어 지원하게 되었습니다.', '저는 예술과 디자인에 대한 열정을 가지고 성장했습니다. 어렸을 때부터 그림 그리기와 디자인에 흥미를 느꼈고, 이러한 관심은 저의 학업과 경력 선택에 큰 영향을 미쳤습니다. 대학에서는 시각디자인을 전공하며 다양한 프로젝트를 수행했고, 이를 통해 디자인 감각과 기술을 연마할 수 있었습니다.', 17),
	(18, '저는 분석적이고 전략적인 사고를 가지고 있습니다. 데이터를 기반으로 한 문제 해결을 좋아하며, 팀과 협력하여 목표를 달성하는 데 큰 보람을 느낍니다. 하지만 때로는 너무 세부적인 부분에 집중하는 경향이 있어 전체적인 그림을 놓칠 때가 있습니다. 이를 보완하기 위해 큰 틀에서 생각하고, 중요한 사항에 집중하려고 노력하고 있습니다.', '이화여자대학교에서의 학업과 연구를 통해 경영에 대한 깊은 이해를 가지게 되었습니다. 한국전력은 혁신적인 경영 전략과 글로벌 시장에서의 성공 사례로 유명한 회사로, 저의 역량을 발휘하기에 최적의 장소라고 생각했습니다. 특히, 한국전력의 글로벌 경영에 기여하고 싶어 지원하게 되었습니다.', '저는 경영과 리더십에 대한 관심이 어렸을 때부터 있었습니다. 부모님께서 운영하시는 작은 가게에서 일을 도우며 자연스럽게 경영에 관심을 갖게 되었고, 이는 저의 학업과 경력 선택에 큰 영향을 미쳤습니다. 대학에서는 경영학을 전공하며 이론과 실무를 겸비한 전문가로 성장하고자 노력했습니다.', 18),
	(19, '저는 분석적이고 논리적인 성격을 가지고 있습니다. 소프트웨어를 통해 문제를 해결하는 과정에서 큰 만족감을 느끼며, 항상 최선의 결과를 도출하기 위해 노력합니다. 하지만 가끔은 너무 기술에만 의존하는 경향이 있어 창의적인 사고를 놓칠 때가 있습니다. 이를 보완하기 위해 다양한 관점에서 문제를 바라보고, 창의적인 해결책을 찾으려고 노력하고 있습니다.', '서강대학교에서의 연구 경험을 통해 소프트웨어 개발의 중요성을 깨닫게 되었습니다. 포스코는 혁신적인 기술과 글로벌 영향력으로 유명한 회사로, 저의 역량을 발휘하기에 최적의 장소라고 생각했습니다. 특히, 포스코의 글로벌 기술 개발에 기여하고 싶어 지원하게 되었습니다.', '저는 컴퓨터와 프로그래밍에 대한 열정이 강한 학생이었습니다. 학교에서는 항상 높은 성적을 유지하며 다양한 프로그래밍 대회에서 수상한 경험이 있습니다. 이러한 경험은 저의 문제 해결 능력을 키워주었고, 대학에서는 컴퓨터공학을 전공하며 소프트웨어 개발 능력을 더욱 발전시킬 수 있었습니다.', 19),
	(20, '저는 논리적이고 체계적인 성격을 가지고 있습니다. 프로젝트를 계획하고 실행하는 과정에서 항상 효율성을 추구하며, 팀과 협력하여 목표를 달성하는 데 큰 보람을 느낍니다. 하지만 가끔은 너무 세부 사항에 집착하는 경향이 있어 전체적인 그림을 놓칠 때가 있습니다. 이를 보완하기 위해 큰 틀에서 생각하고, 중요한 사항에 집중하려고 노력하고 있습니다.', '한양대학교에서의 학업과 연구를 통해 기계공학에 대한 깊은 이해를 가지게 되었습니다. 네이버는 혁신적인 기술과 도전 정신으로 유명한 회사로, 저의 기술적 역량을 발휘하기에 최적의 장소라고 생각했습니다. 특히, 네이버의 글로벌 기술 개발에 기여하고 싶어 지원하게 되었습니다.', '저는 기계와 엔지니어링에 대한 관심이 어렸을 때부터 있었습니다. 부모님께서 운영하시는 작은 공장에서 다양한 기계들을 접할 수 있었고, 이는 저의 호기심을 자극했습니다. 대학에서는 기계공학을 전공하며 이론과 실습을 통해 실력을 쌓았고, 다양한 프로젝트를 수행하며 실무 능력을 키웠습니다.', 20);

-- 테이블 jobbingsoo.cs 구조 내보내기
CREATE TABLE IF NOT EXISTS `cs` (
  `cs_code` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `public_type` varchar(255) DEFAULT NULL,
  `result` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `rid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cs_code`),
  KEY `FKklu8o9my075rja8kvxg3k0g0a` (`rid`),
  CONSTRAINT `FKklu8o9my075rja8kvxg3k0g0a` FOREIGN KEY (`rid`) REFERENCES `member` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 jobbingsoo.cs:~20 rows (대략적) 내보내기
DELETE FROM `cs`;
INSERT INTO `cs` (`cs_code`, `content`, `date`, `public_type`, `result`, `title`, `type`, `rid`) VALUES
	(1, '로그인 시도 시 오류 메시지가 뜹니다.', '2023-06-01', 'T', '답변 완료', '로그인 문제', '문의', NULL),
	(2, '부적절한 광고가 게시되었습니다.', '2023-06-02', 'F', '미답변', '광고 관련 신고', '신고', NULL),
	(3, '비밀번호를 변경하고 싶습니다.', '2023-06-03', 'T', '답변 완료', '계정 비밀번호 변경', '문의', NULL),
	(4, '사이트에 불법 콘텐츠가 올라와 있습니다.', '2023-06-04', 'F', '미답변', '불법 콘텐츠 신고', '신고', NULL),
	(5, '프리미엄 서비스 이용 방법을 알고 싶습니다.', '2023-06-05', 'T', '답변 완료', '서비스 이용 문의', '문의', NULL),
	(6, '개인정보 수정이 불가능합니다.', '2023-06-06', 'F', '답변 완료', '개인정보 수정', '문의', NULL),
	(7, '계정을 탈퇴하고 싶습니다.', '2023-06-07', 'T', '답변 완료', '회원 탈퇴 요청', '문의', NULL),
	(8, '거래 중 사기를 당했습니다.', '2023-06-08', 'F', '미답변', '사기 신고', '신고', NULL),
	(9, '결제 시 오류가 발생합니다.', '2023-06-09', 'T', '답변 완료', '결제 오류', '문의', NULL),
	(10, '저작권이 있는 콘텐츠가 무단으로 사용되었습니다.', '2023-06-10', 'F', '미답변', '콘텐츠 저작권 침해', '신고', NULL),
	(11, '회원 등급에 대해 문의드립니다.', '2023-06-11', 'T', '답변 완료', '회원 등급 문의', '문의', NULL),
	(12, '비정상적인 활동이 감지되었습니다.', '2023-06-12', 'F', '미답변', '비정상적인 활동 신고', '신고', NULL),
	(13, '새로운 기능 추가를 요청합니다.', '2023-06-13', 'T', '답변 완료', '기능 추가 요청', '문의', NULL),
	(14, '악성 댓글이 게시되었습니다.', '2023-06-14', 'F', '미답변', '악성 댓글 신고', '신고', NULL),
	(15, '서비스 사용법에 대해 자세히 알고 싶습니다.', '2023-06-15', 'T', '답변 완료', '서비스 사용법', '문의', NULL),
	(16, '스팸 메시지가 도착했습니다.', '2023-06-16', 'F', '미답변', '스팸 신고', '신고', NULL),
	(17, '계정을 복구하고 싶습니다.', '2023-06-17', 'T', '답변 완료', '계정 복구', '문의', NULL),
	(18, '불법 프로그램이 사용되고 있습니다.', '2023-06-18', 'F', '미답변', '불법 프로그램 신고', '신고', NULL),
	(19, '결제 내역을 확인하고 싶습니다.', '2023-06-19', 'T', '답변 완료', '결제 관련 문의', '문의', NULL),
	(20, '부적절한 콘텐츠가 게시되었습니다.', '2023-06-20', 'F', '미답변', '부적절한 콘텐츠 신고', '신고', NULL);

-- 테이블 jobbingsoo.cs_reply 구조 내보내기
CREATE TABLE IF NOT EXISTS `cs_reply` (
  `csr_code` bigint(20) NOT NULL AUTO_INCREMENT,
  `comment` varchar(255) DEFAULT NULL,
  `cs_code` bigint(20) DEFAULT NULL,
  `mid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`csr_code`),
  KEY `FKo82nalssdqppg8vfto4pefdov` (`cs_code`),
  KEY `FKibjfka4frks12p9813kfkn1no` (`mid`),
  CONSTRAINT `FKibjfka4frks12p9813kfkn1no` FOREIGN KEY (`mid`) REFERENCES `member` (`username`),
  CONSTRAINT `FKo82nalssdqppg8vfto4pefdov` FOREIGN KEY (`cs_code`) REFERENCES `cs` (`cs_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 jobbingsoo.cs_reply:~0 rows (대략적) 내보내기
DELETE FROM `cs_reply`;

-- 테이블 jobbingsoo.desired_area 구조 내보내기
CREATE TABLE IF NOT EXISTS `desired_area` (
  `da_code` bigint(20) NOT NULL AUTO_INCREMENT,
  `area_main` varchar(255) DEFAULT NULL,
  `area_sub` varchar(255) DEFAULT NULL,
  `resume_code` bigint(20) DEFAULT NULL,
  `rid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`da_code`),
  KEY `FKs6p58q7x7vehhffbpgeifvvxr` (`resume_code`),
  KEY `FK74i27i15lohqhdxpjtnl6dym0` (`rid`),
  CONSTRAINT `FK74i27i15lohqhdxpjtnl6dym0` FOREIGN KEY (`rid`) REFERENCES `member` (`username`),
  CONSTRAINT `FKs6p58q7x7vehhffbpgeifvvxr` FOREIGN KEY (`resume_code`) REFERENCES `resume` (`resume_code`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 jobbingsoo.desired_area:~20 rows (대략적) 내보내기
DELETE FROM `desired_area`;
INSERT INTO `desired_area` (`da_code`, `area_main`, `area_sub`, `resume_code`, `rid`) VALUES
	(1, '서울', '강남구', 1, 'user1'),
	(2, '부산', '해운대구', 2, 'user1'),
	(3, '서울', '마포구', 3, 'user2'),
	(4, '대구', '중구', 4, 'user2'),
	(5, '서울', '강서구', 5, 'user3'),
	(6, '인천', '연수구', 6, 'user3'),
	(7, '서울', '서초구', 7, 'user4'),
	(8, '광주', '서구', 8, 'user4'),
	(9, '서울', '송파구', 9, 'user5'),
	(10, '대전', '유성구', 10, 'user5'),
	(11, '서울', '성동구', 11, 'user6'),
	(12, '울산', '남구', 12, 'user6'),
	(13, '서울', '중구', 13, 'user7'),
	(14, '세종', '세종동', 14, 'user7'),
	(15, '서울', '동대문구', 15, 'user8'),
	(16, '경기', '성남시', 16, 'user8'),
	(17, '서울', '용산구', 17, 'user9'),
	(18, '충북', '청주시', 18, 'user9'),
	(19, '서울', '광진구', 19, 'user10'),
	(20, '전북', '전주시', 20, 'user10');

-- 테이블 jobbingsoo.desired_industry 구조 내보내기
CREATE TABLE IF NOT EXISTS `desired_industry` (
  `di_code` bigint(20) NOT NULL AUTO_INCREMENT,
  `industry` varchar(255) DEFAULT NULL,
  `job` varchar(255) DEFAULT NULL,
  `resume_code` bigint(20) DEFAULT NULL,
  `rid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`di_code`),
  KEY `FK47ows2hjxnj92f4ue6k95xtmu` (`resume_code`),
  KEY `FKin713tvqv1ab6adpa8epl5ggv` (`rid`),
  CONSTRAINT `FK47ows2hjxnj92f4ue6k95xtmu` FOREIGN KEY (`resume_code`) REFERENCES `resume` (`resume_code`),
  CONSTRAINT `FKin713tvqv1ab6adpa8epl5ggv` FOREIGN KEY (`rid`) REFERENCES `member` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 jobbingsoo.desired_industry:~20 rows (대략적) 내보내기
DELETE FROM `desired_industry`;
INSERT INTO `desired_industry` (`di_code`, `industry`, `job`, `resume_code`, `rid`) VALUES
	(1, '정보기술', '소프트웨어 엔지니어', 1, 'user1'),
	(2, '정보기술', '백엔드 개발자', 2, 'user1'),
	(3, '디자인', 'UI/UX 디자이너', 3, 'user2'),
	(4, '디자인', '그래픽 디자이너', 4, 'user2'),
	(5, '마케팅', '마케팅 매니저', 5, 'user3'),
	(6, '광고', '광고 기획자', 6, 'user3'),
	(7, '데이터', '데이터 사이언티스트', 7, 'user4'),
	(8, '데이터', '데이터 엔지니어', 8, 'user4'),
	(9, '기계', '기계 엔지니어', 9, 'user5'),
	(10, '기계', '로봇 엔지니어', 10, 'user5'),
	(11, '콘텐츠', '콘텐츠 크리에이터', 11, 'user6'),
	(12, '콘텐츠', '영상 제작자', 12, 'user6'),
	(13, '정보기술', '웹 개발자', 13, 'user7'),
	(14, '정보기술', '프론트엔드 개발자', 14, 'user7'),
	(15, '경영', '프로젝트 매니저', 15, 'user8'),
	(16, '경영', '경영 컨설턴트', 16, 'user8'),
	(17, '데이터', '데이터 분석가', 17, 'user9'),
	(18, '비즈니스', '비즈니스 분석가', 18, 'user9'),
	(19, '디자인', '그래픽 디자이너', 19, 'user10'),
	(20, '디자인', '브랜드 디자이너', 20, 'user10');

-- 테이블 jobbingsoo.faq 구조 내보내기
CREATE TABLE IF NOT EXISTS `faq` (
  `faq_code` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`faq_code`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 jobbingsoo.faq:~10 rows (대략적) 내보내기
DELETE FROM `faq`;
INSERT INTO `faq` (`faq_code`, `content`, `title`) VALUES
	(1, '회원가입은 홈페이지 상단의 "회원가입" 버튼을 클릭하여 진행할 수 있습니다. 이메일 인증 후, 기본 정보를 입력하면 회원가입이 완료됩니다.', '회원가입은 어떻게 하나요?'),
	(2, '비밀번호를 잊어버리셨다면 로그인 페이지의 "비밀번호 찾기" 링크를 클릭하여 이메일 인증을 통해 비밀번호를 재설정할 수 있습니다.', '비밀번호를 잊어버렸어요.'),
	(3, '서비스 이용 요금은 기본 서비스는 무료이며, 프리미엄 서비스는 월 9,900원입니다. 자세한 요금 정보는 요금 안내 페이지를 참조해 주세요.', '서비스 이용 요금은 얼마인가요?'),
	(4, '결제는 신용카드, 체크카드, 페이팔, 그리고 휴대폰 결제를 통해 가능합니다. 결제 페이지에서 원하는 결제 수단을 선택하여 결제할 수 있습니다.', '결제 수단은 어떤 것이 있나요?'),
	(5, '광고 게재를 원하시는 경우, 광고 문의 페이지를 통해 신청할 수 있습니다. 광고 유형과 게재 위치에 따라 요금이 상이하니 자세한 내용은 광고 안내 페이지를 참조해 주세요.', '광고를 게재하고 싶어요.'),
	(6, '회원 정보 수정은 로그인 후 "내 정보" 페이지에서 가능합니다. 이름, 이메일, 비밀번호 등 기본 정보를 수정할 수 있습니다.', '회원 정보를 수정하고 싶어요.'),
	(7, '회원 탈퇴는 로그인 후 "내 정보" 페이지 하단의 "회원 탈퇴" 버튼을 클릭하여 진행할 수 있습니다. 탈퇴 시 모든 정보가 삭제되며 복구할 수 없습니다.', '탈퇴하고 싶어요.'),
	(8, '이용 약관은 홈페이지 하단의 "이용 약관" 링크를 통해 확인할 수 있습니다. 서비스 이용 시 반드시 이용 약관을 숙지해 주시기 바랍니다.', '이용 약관을 알고 싶어요.'),
	(9, '개인정보 처리방침은 홈페이지 하단의 "개인정보 처리방침" 링크를 통해 확인할 수 있습니다. 개인정보 보호를 위해 최선을 다하고 있습니다.', '개인정보 처리방침은 어디서 확인할 수 있나요?'),
	(10, '고객센터는 홈페이지 상단의 "고객센터" 메뉴를 통해 연락할 수 있습니다. 문의 사항은 이메일 또는 전화로 접수해 주시면 신속히 답변드리겠습니다.', '고객센터는 어떻게 연락하나요?');

-- 테이블 jobbingsoo.favorite 구조 내보내기
CREATE TABLE IF NOT EXISTS `favorite` (
  `favor_code` bigint(20) NOT NULL AUTO_INCREMENT,
  `post_code` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`favor_code`),
  KEY `FKbttjmx6qsfl0fme1r4325oi53` (`post_code`),
  KEY `FK9rch08kv1gc5udbjo88t06gdf` (`username`),
  CONSTRAINT `FK9rch08kv1gc5udbjo88t06gdf` FOREIGN KEY (`username`) REFERENCES `member` (`username`),
  CONSTRAINT `FKbttjmx6qsfl0fme1r4325oi53` FOREIGN KEY (`post_code`) REFERENCES `posting` (`post_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 jobbingsoo.favorite:~0 rows (대략적) 내보내기
DELETE FROM `favorite`;

-- 테이블 jobbingsoo.main_category 구조 내보내기
CREATE TABLE IF NOT EXISTS `main_category` (
  `mccode` bigint(20) NOT NULL,
  `main` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`mccode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 jobbingsoo.main_category:~24 rows (대략적) 내보내기
DELETE FROM `main_category`;
INSERT INTO `main_category` (`mccode`, `main`) VALUES
	(1, '01. 사업관리'),
	(2, '02. 경영·회계·사무'),
	(3, '03. 금융·보험'),
	(4, '04. 교육·자연·사회과학'),
	(5, '05. 법률·경찰·소방·교도·국방'),
	(6, '06. 보건·의료'),
	(7, '07. 사회복지·종교'),
	(8, '08. 문화·예술·디자인·방송'),
	(9, '09. 운전·운송'),
	(10, '10. 영업판매'),
	(11, '11. 경비·청소'),
	(12, '12. 이용·숙박·여행·오락·스포츠'),
	(13, '13. 음식서비스'),
	(14, '14. 건설'),
	(15, '15. 기계'),
	(16, '16. 재료'),
	(17, '17. 화학·바이오'),
	(18, '18. 섬유·의복'),
	(19, '19. 전기·전자'),
	(20, '20. 정보통신'),
	(21, '21. 식품가공'),
	(22, '22. 인쇄·목재·가구·공예'),
	(23, '23. 환경·에너지·안전'),
	(24, '24. 농림어업');

-- 테이블 jobbingsoo.member 구조 내보내기
CREATE TABLE IF NOT EXISTS `member` (
  `username` varchar(255) NOT NULL,
  `join_date` date DEFAULT NULL,
  `kakao_id` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 jobbingsoo.member:~20 rows (대략적) 내보내기
DELETE FROM `member`;
INSERT INTO `member` (`username`, `join_date`, `kakao_id`, `password`, `role`) VALUES
	('user1', NULL, NULL, 'password1', 'BEAN'),
	('user10', NULL, NULL, 'password10', 'BEAN'),
	('user11', NULL, NULL, 'password11', 'COM'),
	('user12', NULL, NULL, 'password12', 'COM'),
	('user13', NULL, NULL, 'password13', 'COM'),
	('user14', NULL, NULL, 'password14', 'COM'),
	('user15', NULL, NULL, 'password15', 'COM'),
	('user16', NULL, NULL, 'password16', 'COM'),
	('user17', NULL, NULL, 'password17', 'COM'),
	('user18', NULL, NULL, 'password18', 'COM'),
	('user19', NULL, NULL, 'password19', 'COM'),
	('user2', NULL, NULL, 'password2', 'BEAN'),
	('user20', NULL, NULL, 'password20', 'COM'),
	('user3', NULL, NULL, 'password3', 'BEAN'),
	('user4', NULL, NULL, 'password4', 'BEAN'),
	('user5', NULL, NULL, 'password5', 'BEAN'),
	('user6', NULL, NULL, 'password6', 'BEAN'),
	('user7', NULL, NULL, 'password7', 'BEAN'),
	('user8', NULL, NULL, 'password8', 'BEAN'),
	('user9', NULL, NULL, 'password9', 'BEAN');

-- 테이블 jobbingsoo.notice 구조 내보내기
CREATE TABLE IF NOT EXISTS `notice` (
  `nt_code` bigint(20) NOT NULL AUTO_INCREMENT,
  `message` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `reciever` varchar(255) DEFAULT NULL,
  `sender` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`nt_code`),
  KEY `FK8i3e5lco4wj4v1dbeg1qx2gaf` (`reciever`),
  KEY `FKdbr53ar2vm9micmgulnb7tjka` (`sender`),
  CONSTRAINT `FK8i3e5lco4wj4v1dbeg1qx2gaf` FOREIGN KEY (`reciever`) REFERENCES `member` (`username`),
  CONSTRAINT `FKdbr53ar2vm9micmgulnb7tjka` FOREIGN KEY (`sender`) REFERENCES `member` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 jobbingsoo.notice:~0 rows (대략적) 내보내기
DELETE FROM `notice`;

-- 테이블 jobbingsoo.posting 구조 내보내기
CREATE TABLE IF NOT EXISTS `posting` (
  `post_code` bigint(20) NOT NULL AUTO_INCREMENT,
  `area` varchar(255) DEFAULT NULL,
  `career` varchar(255) DEFAULT NULL,
  `deadline` date DEFAULT NULL,
  `edu_type` varchar(255) DEFAULT NULL,
  `employment_type` varchar(255) DEFAULT NULL,
  `head_count` int(11) DEFAULT NULL,
  `industry` varchar(255) DEFAULT NULL,
  `job` varchar(255) DEFAULT NULL,
  `main_content` varchar(255) DEFAULT NULL,
  `manager_tel` varchar(255) DEFAULT NULL,
  `pay` int(11) DEFAULT NULL,
  `posted_date` date DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `cid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`post_code`),
  KEY `FKk5yry83uikb2ypp4mjm3llaph` (`cid`),
  CONSTRAINT `FKk5yry83uikb2ypp4mjm3llaph` FOREIGN KEY (`cid`) REFERENCES `member` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 jobbingsoo.posting:~80 rows (대략적) 내보내기
DELETE FROM `posting`;
INSERT INTO `posting` (`post_code`, `area`, `career`, `deadline`, `edu_type`, `employment_type`, `head_count`, `industry`, `job`, `main_content`, `manager_tel`, `pay`, `posted_date`, `title`, `cid`) VALUES
	(1, '서울', '3년 이상', '2023-06-30', '대학 졸업', '경력', 3, '정보기술', '백엔드 개발자', '저희 회사는 혁신적인 IT 솔루션을 제공하는 선도 기업으로, 백엔드 개발자를 모집합니다. 주요 업무는 대규모 트래픽을 처리할 수 있는 안정적인 서버 개발 및 유지보수입니다. Java 및 Spring Framework에 능숙한 분을 찾고 있으며, 클라우드 환경에서의 개발 경험이 있는 분을 우대합니다. 자율적인 근무 환경과 뛰어난 복지 혜택을 제공하며, 글로벌 시장에서 함께 성장할 수 있는 기회를 드립니다.', '010-1234-5678', 70000000, '2023-06-01', '백엔드 개발자 모집', 'user11'),
	(2, '서울', '신입', '2023-06-30', '대학 졸업', '신입', 2, '정보기술', '프론트엔드 개발자', '저희 회사는 사용자 경험을 최우선으로 하는 혁신적인 IT 기업으로, 프론트엔드 개발자를 모집합니다. 주요 업무는 웹 애플리케이션의 사용자 인터페이스 개발 및 최적화입니다. React 및 Vue.js에 능숙한 분을 찾고 있으며, UI/UX 디자인에 대한 이해가 있는 분을 우대합니다. 자유로운 근무 환경과 다양한 복지 혜택을 제공하며, 성장할 수 있는 기회를 드립니다.', '010-1234-5679', 60000000, '2023-06-01', '프론트엔드 개발자 모집', 'user11'),
	(3, '서울', '5년 이상', '2023-07-15', '석사', '경력', 1, '정보기술', '데브옵스 엔지니어', '저희 회사는 클라우드 기반의 혁신적인 서비스를 제공하는 IT 기업으로, 데브옵스 엔지니어를 모집합니다. 주요 업무는 CI/CD 파이프라인 구축 및 유지보수, 클라우드 인프라 관리입니다. AWS, Azure 등의 클라우드 플랫폼 경험이 있는 분을 찾고 있으며, 스크립팅 언어에 능숙한 분을 우대합니다. 자율적인 근무 환경과 경쟁력 있는 연봉을 제공하며, 글로벌 시장에서 함께 성장할 수 있는 기회를 드립니다.', '010-1234-5680', 80000000, '2023-06-01', '데브옵스 엔지니어 채용', 'user11'),
	(4, '서울', '5년 이상', '2023-07-31', '박사', '경력', 2, '데이터', '데이터 사이언티스트', '저희 회사는 데이터 기반의 혁신적인 비즈니스 솔루션을 제공하는 기업으로, 데이터 사이언티스트를 모집합니다. 주요 업무는 데이터 분석 및 머신러닝 모델 개발입니다. Python, R에 능숙한 분을 찾고 있으며, 빅데이터 플랫폼 경험이 있는 분을 우대합니다. 유연한 근무 환경과 높은 연봉을 제공하며, 데이터 기반의 혁신을 이끌어갈 수 있는 기회를 드립니다.', '010-1234-5681', 90000000, '2023-06-01', '데이터 사이언티스트 모집', 'user11'),
	(5, '부산', '신입', '2023-06-30', '대학 졸업', '신입', 2, '디자인', 'UI/UX 디자이너', '저희 회사는 사용자 중심의 디자인을 추구하는 선도 기업으로, UI/UX 디자이너를 모집합니다. 주요 업무는 모바일 및 웹 애플리케이션의 사용자 인터페이스 설계 및 개선입니다. Adobe XD, Sketch 등에 능숙한 분을 찾고 있으며, 사용자 경험에 대한 깊은 이해를 가진 분을 우대합니다. 창의적이고 도전적인 환경에서 함께 성장할 수 있는 기회를 드립니다.', '010-2345-6789', 50000000, '2023-06-01', 'UI/UX 디자이너 채용', 'user12'),
	(6, '부산', '2년 이상', '2023-06-30', '대학 졸업', '경력', 1, '디자인', '그래픽 디자이너', '저희 회사는 혁신적인 디자인 솔루션을 제공하는 기업으로, 그래픽 디자이너를 모집합니다. 주요 업무는 브랜드 아이덴티티 디자인 및 각종 마케팅 자료 제작입니다. Adobe Photoshop, Illustrator 등에 능숙한 분을 찾고 있으며, 창의적인 아이디어를 시각적으로 구현할 수 있는 분을 우대합니다. 자율적인 근무 환경과 다양한 복지 혜택을 제공합니다.', '010-2345-6790', 55000000, '2023-06-01', '그래픽 디자이너 채용', 'user12'),
	(7, '부산', '3년 이상', '2023-07-15', '대학 졸업', '경력', 1, '디자인', '모션 그래픽 디자이너', '저희 회사는 창의적인 비주얼 콘텐츠를 제작하는 선도 기업으로, 모션 그래픽 디자이너를 모집합니다. 주요 업무는 광고 및 프로모션 비디오의 모션 그래픽 제작입니다. After Effects, Cinema 4D 등에 능숙한 분을 찾고 있으며, 다양한 비디오 편집 경험이 있는 분을 우대합니다. 창의적이고 활기찬 환경에서 함께 성장할 수 있는 기회를 드립니다.', '010-2345-6791', 60000000, '2023-06-01', '모션 그래픽 디자이너 채용', 'user12'),
	(8, '부산', '2년 이상', '2023-07-31', '대학 졸업', '경력', 2, '마케팅', '디지털 마케팅 전문가', '저희 회사는 데이터 기반의 디지털 마케팅 전략을 수립하고 실행하는 기업으로, 디지털 마케팅 전문가를 모집합니다. 주요 업무는 온라인 광고 캠페인 기획 및 운영, SEO 및 SEM 전략 수립입니다. Google Analytics, Facebook Ads 등에 능숙한 분을 찾고 있으며, 데이터 분석을 통해 마케팅 전략을 개선할 수 있는 분을 우대합니다. 도전적인 환경에서 함께 성장할 수 있는 기회를 드립니다.', '010-2345-6792', 65000000, '2023-06-01', '디지털 마케팅 전문가 채용', 'user12'),
	(9, '서울', '3년 이상', '2023-06-30', '대학 졸업', '경력', 3, '마케팅', '마케팅 매니저', '저희 회사는 혁신적인 마케팅 전략을 통해 글로벌 시장을 선도하는 기업으로, 마케팅 매니저를 모집합니다. 주요 업무는 마케팅 캠페인 기획 및 실행, 시장 조사 및 분석입니다. 다양한 마케팅 도구에 능숙한 분을 찾고 있으며, 팀과 협력하여 목표를 달성할 수 있는 분을 우대합니다. 창의적이고 도전적인 환경에서 함께 성장할 수 있는 기회를 드립니다.', '010-3456-7890', 70000000, '2023-06-01', '마케팅 매니저 모집', 'user13'),
	(10, '서울', '4년 이상', '2023-07-15', '대학 졸업', '경력', 2, '마케팅', '브랜드 매니저', '저희 회사는 강력한 브랜드 아이덴티티를 구축하고 있는 글로벌 기업으로, 브랜드 매니저를 모집합니다. 주요 업무는 브랜드 전략 수립 및 실행, 브랜드 캠페인 관리입니다. 브랜드 관리 및 마케팅 경험이 풍부한 분을 찾고 있으며, 창의적인 아이디어를 실현할 수 있는 분을 우대합니다. 자율적인 근무 환경과 경쟁력 있는 연봉을 제공합니다.', '010-3456-7891', 75000000, '2023-06-01', '브랜드 매니저 채용', 'user13'),
	(11, '서울', '2년 이상', '2023-07-31', '대학 졸업', '경력', 2, '마케팅', '콘텐츠 마케팅 전문가', '저희 회사는 콘텐츠 중심의 마케팅 전략을 통해 시장을 선도하는 기업으로, 콘텐츠 마케팅 전문가를 모집합니다. 주요 업무는 블로그, 소셜 미디어 등 다양한 채널을 통한 콘텐츠 기획 및 제작입니다. 콘텐츠 마케팅 경험이 풍부한 분을 찾고 있으며, 창의적이고 전략적인 사고를 가진 분을 우대합니다. 도전적인 환경에서 함께 성장할 수 있는 기회를 드립니다.', '010-3456-7892', 65000000, '2023-06-01', '콘텐츠 마케팅 전문가 모집', 'user13'),
	(12, '서울', '3년 이상', '2023-07-15', '대학 졸업', '경력', 1, '마케팅', '디지털 광고 전문가', '저희 회사는 데이터 기반의 디지털 광고 전략을 수립하고 실행하는 기업으로, 디지털 광고 전문가를 모집합니다. 주요 업무는 온라인 광고 캠페인 기획 및 운영, 광고 성과 분석입니다. Google Ads, Facebook Ads 등에 능숙한 분을 찾고 있으며, 데이터 분석을 통해 광고 성과를 개선할 수 있는 분을 우대합니다. 도전적인 환경에서 함께 성장할 수 있는 기회를 드립니다.', '010-3456-7893', 68000000, '2023-06-01', '디지털 광고 전문가 채용', 'user13'),
	(13, '서울', '5년 이상', '2023-06-30', '석사', '경력', 3, '데이터', '데이터 분석가', '저희 회사는 데이터 기반의 비즈니스 인사이트를 제공하는 선도 기업으로, 데이터 분석가를 모집합니다. 주요 업무는 데이터 분석 및 시각화, 비즈니스 인사이트 도출입니다. Python, R 등에 능숙한 분을 찾고 있으며, 데이터 시각화 도구 사용 경험이 있는 분을 우대합니다. 자율적인 근무 환경과 뛰어난 복지 혜택을 제공하며, 글로벌 시장에서 함께 성장할 수 있는 기회를 드립니다.', '010-4567-8901', 80000000, '2023-06-01', '데이터 분석가 채용', 'user14'),
	(14, '서울', '3년 이상', '2023-07-15', '석사', '경력', 2, '데이터', '머신러닝 엔지니어', '저희 회사는 머신러닝 기술을 활용한 혁신적인 솔루션을 제공하는 기업으로, 머신러닝 엔지니어를 모집합니다. 주요 업무는 머신러닝 모델 개발 및 배포입니다. Python, TensorFlow, Keras 등에 능숙한 분을 찾고 있으며, 대규모 데이터셋 처리 경험이 있는 분을 우대합니다. 창의적이고 도전적인 환경에서 함께 성장할 수 있는 기회를 드립니다.', '010-4567-8902', 85000000, '2023-06-01', '머신러닝 엔지니어 모집', 'user14'),
	(15, '서울', '3년 이상', '2023-07-31', '대학 졸업', '경력', 2, '데이터', '데이터 엔지니어', '저희 회사는 데이터 인프라 구축 및 관리를 전문으로 하는 기업으로, 데이터 엔지니어를 모집합니다. 주요 업무는 데이터 파이프라인 설계 및 데이터베이스 관리입니다. SQL, Hadoop, Spark 등에 능숙한 분을 찾고 있으며, 클라우드 환경에서의 데이터 처리 경험이 있는 분을 우대합니다. 자율적인 근무 환경과 경쟁력 있는 연봉을 제공합니다.', '010-4567-8903', 70000000, '2023-06-01', '데이터 엔지니어 채용', 'user14'),
	(16, '서울', '5년 이상', '2023-07-15', '석사', '경력', 1, '데이터', '빅데이터 전문가', '저희 회사는 빅데이터 분석을 통한 비즈니스 혁신을 주도하는 기업으로, 빅데이터 전문가를 모집합니다. 주요 업무는 대규모 데이터셋의 수집, 처리 및 분석입니다. Hadoop, Spark, Kafka 등에 능숙한 분을 찾고 있으며, 빅데이터 플랫폼 경험이 있는 분을 우대합니다. 유연한 근무 환경과 높은 연봉을 제공하며, 데이터 기반의 혁신을 이끌어갈 수 있는 기회를 드립니다.', '010-4567-8904', 90000000, '2023-06-01', '빅데이터 전문가 모집', 'user14'),
	(17, '서울', '3년 이상', '2023-06-30', '대학 졸업', '경력', 2, '기계', '기계 엔지니어', '저희 회사는 첨단 기술을 활용한 기계 설계 및 제조를 전문으로 하는 기업으로, 기계 엔지니어를 모집합니다. 주요 업무는 기계 부품 설계 및 제작, 성능 개선입니다. AutoCAD, SolidWorks 등에 능숙한 분을 찾고 있으며, 기계 공학 분야에서의 경험이 있는 분을 우대합니다. 자율적인 근무 환경과 경쟁력 있는 연봉을 제공합니다.', '010-5678-9012', 65000000, '2023-06-01', '기계 엔지니어 모집', 'user15'),
	(18, '서울', '5년 이상', '2023-07-15', '석사', '경력', 2, '기계', '로봇 엔지니어', '저희 회사는 로봇 공학 기술을 활용한 혁신적인 솔루션을 제공하는 기업으로, 로봇 엔지니어를 모집합니다. 주요 업무는 로봇 시스템 설계 및 개발, 로봇 제어 알고리즘 개발입니다. MATLAB, Simulink 등에 능숙한 분을 찾고 있으며, 로봇 공학 분야에서의 경험이 있는 분을 우대합니다. 창의적이고 도전적인 환경에서 함께 성장할 수 있는 기회를 드립니다.', '010-5678-9013', 75000000, '2023-06-01', '로봇 엔지니어 채용', 'user15'),
	(19, '서울', '2년 이상', '2023-07-31', '대학 졸업', '경력', 1, '기계', '기계 설계 엔지니어', '저희 회사는 고도화된 기계 설계 및 제조 기술을 보유한 기업으로, 기계 설계 엔지니어를 모집합니다. 주요 업무는 기계 설계 도면 작성 및 3D 모델링입니다. CAD, CATIA 등에 능숙한 분을 찾고 있으며, 기계 설계 경험이 있는 분을 우대합니다. 유연한 근무 환경과 높은 연봉을 제공하며, 기계 설계의 혁신을 이끌어갈 수 있는 기회를 드립니다.', '010-5678-9014', 60000000, '2023-06-01', '기계 설계 엔지니어 채용', 'user15'),
	(20, '서울', '신입', '2023-07-15', '대학 졸업', '신입', 1, '기계', '제품 엔지니어', '저희 회사는 혁신적인 제품 설계 및 제조를 전문으로 하는 기업으로, 제품 엔지니어를 모집합니다. 주요 업무는 제품 설계 및 개발, 프로토타입 제작입니다. AutoCAD, SolidWorks 등에 능숙한 분을 찾고 있으며, 신입 지원자도 환영합니다. 창의적이고 도전적인 환경에서 함께 성장할 수 있는 기회를 드립니다.', '010-5678-9015', 55000000, '2023-06-01', '제품 엔지니어 채용', 'user15'),
	(21, '서울', '신입', '2023-06-30', '대학 졸업', '신입', 2, '콘텐츠', '콘텐츠 크리에이터', '저희 회사는 창의적인 콘텐츠 제작을 통해 다양한 미디어 플랫폼에서 활동하는 기업으로, 콘텐츠 크리에이터를 모집합니다. 주요 업무는 동영상 콘텐츠 기획 및 제작, 소셜 미디어 운영입니다. 영상 편집 도구에 능숙한 분을 찾고 있으며, 창의적인 아이디어를 가진 분을 우대합니다. 자유로운 근무 환경과 다양한 복지 혜택을 제공합니다.', '010-6789-0123', 50000000, '2023-06-01', '콘텐츠 크리에이터 모집', 'user16'),
	(22, '서울', '2년 이상', '2023-06-30', '대학 졸업', '경력', 2, '콘텐츠', '영상 편집자', '저희 회사는 고퀄리티 영상 콘텐츠 제작을 전문으로 하는 기업으로, 영상 편집자를 모집합니다. 주요 업무는 촬영된 영상의 편집 및 후반 작업입니다. Adobe Premiere, After Effects 등에 능숙한 분을 찾고 있으며, 다양한 편집 경험이 있는 분을 우대합니다. 자율적인 근무 환경과 경쟁력 있는 연봉을 제공합니다.', '010-6789-0124', 55000000, '2023-06-01', '영상 편집자 채용', 'user16'),
	(23, '서울', '3년 이상', '2023-07-15', '대학 졸업', '경력', 1, '콘텐츠', '프로듀서', '저희 회사는 혁신적인 콘텐츠 제작을 주도하는 기업으로, 프로듀서를 모집합니다. 주요 업무는 콘텐츠 기획 및 제작, 제작팀 관리입니다. 프로젝트 관리 및 제작 경험이 풍부한 분을 찾고 있으며, 창의적이고 리더십을 가진 분을 우대합니다. 창의적이고 도전적인 환경에서 함께 성장할 수 있는 기회를 드립니다.', '010-6789-0125', 65000000, '2023-06-01', '프로듀서 채용', 'user16'),
	(24, '서울', '2년 이상', '2023-07-31', '대학 졸업', '경력', 1, '콘텐츠', '방송 작가', '저희 회사는 다양한 방송 콘텐츠 제작을 전문으로 하는 기업으로, 방송 작가를 모집합니다. 주요 업무는 방송 대본 작성 및 콘텐츠 기획입니다. 창의적인 글쓰기 능력을 가진 분을 찾고 있으며, 방송 작가 경험이 있는 분을 우대합니다. 유연한 근무 환경과 높은 연봉을 제공하며, 콘텐츠 제작의 혁신을 이끌어갈 수 있는 기회를 드립니다.', '010-6789-0126', 60000000, '2023-06-01', '방송 작가 채용', 'user16'),
	(25, '서울', '2년 이상', '2023-06-30', '대학 졸업', '경력', 3, '정보기술', '웹 개발자', '저희 회사는 웹 애플리케이션 개발을 전문으로 하는 IT 기업으로, 웹 개발자를 모집합니다. 주요 업무는 웹 애플리케이션의 개발 및 유지보수입니다. HTML, CSS, JavaScript 등에 능숙한 분을 찾고 있으며, 프론트엔드 또는 백엔드 개발 경험이 있는 분을 우대합니다. 자율적인 근무 환경과 다양한 복지 혜택을 제공합니다.', '010-7890-1234', 65000000, '2023-06-01', '웹 개발자 모집', 'user17'),
	(26, '서울', '3년 이상', '2023-06-30', '대학 졸업', '경력', 2, '정보기술', '모바일 앱 개발자', '저희 회사는 혁신적인 모바일 애플리케이션을 개발하는 IT 기업으로, 모바일 앱 개발자를 모집합니다. 주요 업무는 iOS 및 Android 앱 개발 및 유지보수입니다. Swift, Kotlin 등에 능숙한 분을 찾고 있으며, 모바일 앱 개발 경험이 있는 분을 우대합니다. 창의적이고 도전적인 환경에서 함께 성장할 수 있는 기회를 드립니다.', '010-7890-1235', 70000000, '2023-06-01', '모바일 앱 개발자 채용', 'user17'),
	(27, '서울', '5년 이상', '2023-07-15', '석사', '경력', 1, '데이터', '데이터 엔지니어', '저희 회사는 데이터 인프라 구축 및 관리를 전문으로 하는 기업으로, 데이터 엔지니어를 모집합니다. 주요 업무는 데이터 파이프라인 설계 및 데이터베이스 관리입니다. SQL, Hadoop, Spark 등에 능숙한 분을 찾고 있으며, 클라우드 환경에서의 데이터 처리 경험이 있는 분을 우대합니다. 자율적인 근무 환경과 경쟁력 있는 연봉을 제공합니다.', '010-7890-1236', 80000000, '2023-06-01', '데이터 엔지니어 채용', 'user17'),
	(28, '서울', '3년 이상', '2023-07-31', '대학 졸업', '경력', 2, '정보기술', '시스템 엔지니어', '저희 회사는 IT 인프라 설계 및 관리를 전문으로 하는 기업으로, 시스템 엔지니어를 모집합니다. 주요 업무는 서버 및 네트워크 관리, 시스템 최적화입니다. Linux, Windows 서버 관리 경험이 있는 분을 찾고 있으며, 시스템 보안에 대한 이해가 있는 분을 우대합니다. 유연한 근무 환경과 높은 연봉을 제공하며, 시스템 관리의 혁신을 이끌어갈 수 있는 기회를 드립니다.', '010-7890-1237', 75000000, '2023-06-01', '시스템 엔지니어 채용', 'user17'),
	(29, '서울', '5년 이상', '2023-06-30', '석사', '경력', 3, '경영', '경영 컨설턴트', '저희 회사는 경영 전략 수립 및 실행을 지원하는 선도 기업으로, 경영 컨설턴트를 모집합니다. 주요 업무는 기업의 경영 전략 분석 및 개선 방안 제시입니다. 경영 컨설팅 경험이 풍부한 분을 찾고 있으며, 전략적 사고와 문제 해결 능력을 가진 분을 우대합니다. 자율적인 근무 환경과 경쟁력 있는 연봉을 제공합니다.', '010-8901-2345', 90000000, '2023-06-01', '경영 컨설턴트 채용', 'user18'),
	(30, '서울', '3년 이상', '2023-06-30', '대학 졸업', '경력', 2, '경영', '프로젝트 매니저', '저희 회사는 다양한 프로젝트를 성공적으로 이끄는 기업으로, 프로젝트 매니저를 모집합니다. 주요 업무는 프로젝트 기획 및 실행, 팀 관리입니다. 프로젝트 관리 경험이 풍부한 분을 찾고 있으며, 리더십과 조직 관리 능력을 가진 분을 우대합니다. 창의적이고 도전적인 환경에서 함께 성장할 수 있는 기회를 드립니다.', '010-8901-2346', 75000000, '2023-06-01', '프로젝트 매니저 채용', 'user18'),
	(31, '서울', '2년 이상', '2023-07-15', '대학 졸업', '경력', 2, '경영', '재무 분석가', '저희 회사는 재무 전략 수립 및 실행을 지원하는 선도 기업으로, 재무 분석가를 모집합니다. 주요 업무는 기업의 재무 상태 분석 및 개선 방안 제시입니다. 재무 분석 경험이 풍부한 분을 찾고 있으며, 전략적 사고와 문제 해결 능력을 가진 분을 우대합니다. 자율적인 근무 환경과 경쟁력 있는 연봉을 제공합니다.', '010-8901-2347', 70000000, '2023-06-01', '재무 분석가 채용', 'user18'),
	(32, '서울', '3년 이상', '2023-07-31', '대학 졸업', '경력', 1, '경영', '비즈니스 애널리스트', '저희 회사는 비즈니스 전략 분석 및 실행을 지원하는 선도 기업으로, 비즈니스 애널리스트를 모집합니다. 주요 업무는 기업의 비즈니스 프로세스 분석 및 개선 방안 제시입니다. 비즈니스 분석 경험이 풍부한 분을 찾고 있으며, 전략적 사고와 문제 해결 능력을 가진 분을 우대합니다. 유연한 근무 환경과 높은 연봉을 제공하며, 비즈니스 혁신을 이끌어갈 수 있는 기회를 드립니다.', '010-8901-2348', 80000000, '2023-06-01', '비즈니스 애널리스트 채용', 'user18'),
	(33, '서울', '5년 이상', '2023-06-30', '박사', '경력', 3, '데이터', '데이터 사이언티스트', '저희 회사는 데이터 분석을 통한 비즈니스 혁신을 주도하는 기업으로, 데이터 사이언티스트를 모집합니다. 주요 업무는 데이터 분석 및 머신러닝 모델 개발입니다. Python, R 등에 능숙한 분을 찾고 있으며, 데이터 분석 및 모델링 경험이 풍부한 분을 우대합니다. 자율적인 근무 환경과 뛰어난 복지 혜택을 제공하며, 글로벌 시장에서 함께 성장할 수 있는 기회를 드립니다.', '010-9012-3456', 95000000, '2023-06-01', '데이터 사이언티스트 모집', 'user19'),
	(34, '서울', '3년 이상', '2023-06-30', '석사', '경력', 2, '데이터', '데이터 엔지니어', '저희 회사는 데이터 인프라 구축 및 관리를 전문으로 하는 기업으로, 데이터 엔지니어를 모집합니다. 주요 업무는 데이터 파이프라인 설계 및 데이터베이스 관리입니다. SQL, Hadoop, Spark 등에 능숙한 분을 찾고 있으며, 클라우드 환경에서의 데이터 처리 경험이 있는 분을 우대합니다. 자율적인 근무 환경과 경쟁력 있는 연봉을 제공합니다.', '010-9012-3457', 80000000, '2023-06-01', '데이터 엔지니어 채용', 'user19'),
	(35, '서울', '4년 이상', '2023-07-15', '석사', '경력', 2, '데이터', '빅데이터 분석가', '저희 회사는 빅데이터 분석을 통한 비즈니스 혁신을 주도하는 기업으로, 빅데이터 분석가를 모집합니다. 주요 업무는 대규모 데이터셋의 분석 및 인사이트 도출입니다. Hadoop, Spark, Kafka 등에 능숙한 분을 찾고 있으며, 빅데이터 플랫폼 경험이 있는 분을 우대합니다. 창의적이고 도전적인 환경에서 함께 성장할 수 있는 기회를 드립니다.', '010-9012-3458', 85000000, '2023-06-01', '빅데이터 분석가 채용', 'user19'),
	(36, '서울', '2년 이상', '2023-07-31', '대학 졸업', '경력', 2, '데이터', '데이터 분석가', '저희 회사는 데이터 분석을 통한 비즈니스 혁신을 주도하는 기업으로, 데이터 분석가를 모집합니다. 주요 업무는 데이터 분석 및 시각화, 비즈니스 인사이트 도출입니다. Python, R 등에 능숙한 분을 찾고 있으며, 데이터 시각화 도구 사용 경험이 있는 분을 우대합니다. 자율적인 근무 환경과 뛰어난 복지 혜택을 제공하며, 글로벌 시장에서 함께 성장할 수 있는 기회를 드립니다.', '010-9012-3459', 70000000, '2023-06-01', '데이터 분석가 모집', 'user19'),
	(37, '서울', '신입', '2023-06-30', '대학 졸업', '신입', 2, '디자인', '그래픽 디자이너', '저희 회사는 혁신적인 디자인 솔루션을 제공하는 기업으로, 그래픽 디자이너를 모집합니다. 주요 업무는 브랜드 아이덴티티 디자인 및 각종 마케팅 자료 제작입니다. Adobe Photoshop, Illustrator 등에 능숙한 분을 찾고 있으며, 창의적인 아이디어를 시각적으로 구현할 수 있는 분을 우대합니다. 자율적인 근무 환경과 다양한 복지 혜택을 제공합니다.', '010-0123-4567', 50000000, '2023-06-01', '그래픽 디자이너 모집', 'user20'),
	(38, '서울', '2년 이상', '2023-06-30', '대학 졸업', '경력', 2, '디자인', 'UI/UX 디자이너', '저희 회사는 사용자 중심의 디자인을 추구하는 선도 기업으로, UI/UX 디자이너를 모집합니다. 주요 업무는 모바일 및 웹 애플리케이션의 사용자 인터페이스 설계 및 개선입니다. Adobe XD, Sketch 등에 능숙한 분을 찾고 있으며, 사용자 경험에 대한 깊은 이해를 가진 분을 우대합니다. 창의적이고 도전적인 환경에서 함께 성장할 수 있는 기회를 드립니다.', '010-0123-4568', 55000000, '2023-06-01', 'UI/UX 디자이너 채용', 'user20'),
	(39, '서울', '3년 이상', '2023-07-15', '대학 졸업', '경력', 1, '디자인', '모션 그래픽 디자이너', '저희 회사는 창의적인 비주얼 콘텐츠를 제작하는 선도 기업으로, 모션 그래픽 디자이너를 모집합니다. 주요 업무는 광고 및 프로모션 비디오의 모션 그래픽 제작입니다. After Effects, Cinema 4D 등에 능숙한 분을 찾고 있으며, 다양한 비디오 편집 경험이 있는 분을 우대합니다. 창의적이고 활기찬 환경에서 함께 성장할 수 있는 기회를 드립니다.', '010-0123-4569', 60000000, '2023-06-01', '모션 그래픽 디자이너 모집', 'user20'),
	(40, '서울', '5년 이상', '2023-07-31', '대학 졸업', '경력', 2, '디자인', '브랜드 디자이너', '저희 회사는 강력한 브랜드 아이덴티티를 구축하고 있는 글로벌 기업으로, 브랜드 디자이너를 모집합니다. 주요 업무는 브랜드 전략 수립 및 실행, 브랜드 캠페인 관리입니다. 브랜드 관리 및 디자인 경험이 풍부한 분을 찾고 있으며, 창의적인 아이디어를 실현할 수 있는 분을 우대합니다. 자율적인 근무 환경과 경쟁력 있는 연봉을 제공합니다.', '010-0123-4570', 70000000, '2023-06-01', '브랜드 디자이너 채용', 'user20'),
	(41, '서울', '3년 이상', '2024-06-30', '대학 졸업', '경력', 3, '정보기술', '백엔드 개발자', '저희 회사는 혁신적인 IT 솔루션을 제공하는 선도 기업으로, 백엔드 개발자를 모집합니다. 주요 업무는 대규모 트래픽을 처리할 수 있는 안정적인 서버 개발 및 유지보수입니다. Java 및 Spring Framework에 능숙한 분을 찾고 있으며, 클라우드 환경에서의 개발 경험이 있는 분을 우대합니다. 자율적인 근무 환경과 뛰어난 복지 혜택을 제공하며, 글로벌 시장에서 함께 성장할 수 있는 기회를 드립니다.', '010-1234-5678', 70000000, '2023-06-01', '백엔드 개발자 모집', 'user11'),
	(42, '서울', '신입', '2024-06-30', '대학 졸업', '신입', 2, '정보기술', '프론트엔드 개발자', '저희 회사는 사용자 경험을 최우선으로 하는 혁신적인 IT 기업으로, 프론트엔드 개발자를 모집합니다. 주요 업무는 웹 애플리케이션의 사용자 인터페이스 개발 및 최적화입니다. React 및 Vue.js에 능숙한 분을 찾고 있으며, UI/UX 디자인에 대한 이해가 있는 분을 우대합니다. 자유로운 근무 환경과 다양한 복지 혜택을 제공하며, 성장할 수 있는 기회를 드립니다.', '010-1234-5679', 60000000, '2023-06-01', '프론트엔드 개발자 모집', 'user11'),
	(43, '서울', '5년 이상', '2024-07-15', '석사', '경력', 1, '정보기술', '데브옵스 엔지니어', '저희 회사는 클라우드 기반의 혁신적인 서비스를 제공하는 IT 기업으로, 데브옵스 엔지니어를 모집합니다. 주요 업무는 CI/CD 파이프라인 구축 및 유지보수, 클라우드 인프라 관리입니다. AWS, Azure 등의 클라우드 플랫폼 경험이 있는 분을 찾고 있으며, 스크립팅 언어에 능숙한 분을 우대합니다. 자율적인 근무 환경과 경쟁력 있는 연봉을 제공하며, 글로벌 시장에서 함께 성장할 수 있는 기회를 드립니다.', '010-1234-5680', 80000000, '2023-06-01', '데브옵스 엔지니어 채용', 'user11'),
	(44, '서울', '5년 이상', '2023-07-31', '박사', '경력', 2, '데이터', '데이터 사이언티스트', '저희 회사는 데이터 기반의 혁신적인 비즈니스 솔루션을 제공하는 기업으로, 데이터 사이언티스트를 모집합니다. 주요 업무는 데이터 분석 및 머신러닝 모델 개발입니다. Python, R에 능숙한 분을 찾고 있으며, 빅데이터 플랫폼 경험이 있는 분을 우대합니다. 유연한 근무 환경과 높은 연봉을 제공하며, 데이터 기반의 혁신을 이끌어갈 수 있는 기회를 드립니다.', '010-1234-5681', 90000000, '2023-06-01', '데이터 사이언티스트 모집', 'user11'),
	(45, '부산', '신입', '2024-06-30', '대학 졸업', '신입', 2, '디자인', 'UI/UX 디자이너', '저희 회사는 사용자 중심의 디자인을 추구하는 선도 기업으로, UI/UX 디자이너를 모집합니다. 주요 업무는 모바일 및 웹 애플리케이션의 사용자 인터페이스 설계 및 개선입니다. Adobe XD, Sketch 등에 능숙한 분을 찾고 있으며, 사용자 경험에 대한 깊은 이해를 가진 분을 우대합니다. 창의적이고 도전적인 환경에서 함께 성장할 수 있는 기회를 드립니다.', '010-2345-6789', 50000000, '2023-06-01', 'UI/UX 디자이너 채용', 'user12'),
	(46, '부산', '2년 이상', '2024-06-30', '대학 졸업', '경력', 1, '디자인', '그래픽 디자이너', '저희 회사는 혁신적인 디자인 솔루션을 제공하는 기업으로, 그래픽 디자이너를 모집합니다. 주요 업무는 브랜드 아이덴티티 디자인 및 각종 마케팅 자료 제작입니다. Adobe Photoshop, Illustrator 등에 능숙한 분을 찾고 있으며, 창의적인 아이디어를 시각적으로 구현할 수 있는 분을 우대합니다. 자율적인 근무 환경과 다양한 복지 혜택을 제공합니다.', '010-2345-6790', 55000000, '2023-06-01', '그래픽 디자이너 채용', 'user12'),
	(47, '부산', '3년 이상', '2024-07-15', '대학 졸업', '경력', 1, '디자인', '모션 그래픽 디자이너', '저희 회사는 창의적인 비주얼 콘텐츠를 제작하는 선도 기업으로, 모션 그래픽 디자이너를 모집합니다. 주요 업무는 광고 및 프로모션 비디오의 모션 그래픽 제작입니다. After Effects, Cinema 4D 등에 능숙한 분을 찾고 있으며, 다양한 비디오 편집 경험이 있는 분을 우대합니다. 창의적이고 활기찬 환경에서 함께 성장할 수 있는 기회를 드립니다.', '010-2345-6791', 60000000, '2023-06-01', '모션 그래픽 디자이너 채용', 'user12'),
	(48, '부산', '2년 이상', '2023-07-31', '대학 졸업', '경력', 2, '마케팅', '디지털 마케팅 전문가', '저희 회사는 데이터 기반의 디지털 마케팅 전략을 수립하고 실행하는 기업으로, 디지털 마케팅 전문가를 모집합니다. 주요 업무는 온라인 광고 캠페인 기획 및 운영, SEO 및 SEM 전략 수립입니다. Google Analytics, Facebook Ads 등에 능숙한 분을 찾고 있으며, 데이터 분석을 통해 마케팅 전략을 개선할 수 있는 분을 우대합니다. 도전적인 환경에서 함께 성장할 수 있는 기회를 드립니다.', '010-2345-6792', 65000000, '2023-06-01', '디지털 마케팅 전문가 채용', 'user12'),
	(49, '서울', '3년 이상', '2024-06-30', '대학 졸업', '경력', 3, '마케팅', '마케팅 매니저', '저희 회사는 혁신적인 마케팅 전략을 통해 글로벌 시장을 선도하는 기업으로, 마케팅 매니저를 모집합니다. 주요 업무는 마케팅 캠페인 기획 및 실행, 시장 조사 및 분석입니다. 다양한 마케팅 도구에 능숙한 분을 찾고 있으며, 팀과 협력하여 목표를 달성할 수 있는 분을 우대합니다. 창의적이고 도전적인 환경에서 함께 성장할 수 있는 기회를 드립니다.', '010-3456-7890', 70000000, '2023-06-01', '마케팅 매니저 모집', 'user13'),
	(50, '서울', '4년 이상', '2024-07-15', '대학 졸업', '경력', 2, '마케팅', '브랜드 매니저', '저희 회사는 강력한 브랜드 아이덴티티를 구축하고 있는 글로벌 기업으로, 브랜드 매니저를 모집합니다. 주요 업무는 브랜드 전략 수립 및 실행, 브랜드 캠페인 관리입니다. 브랜드 관리 및 마케팅 경험이 풍부한 분을 찾고 있으며, 창의적인 아이디어를 실현할 수 있는 분을 우대합니다. 자율적인 근무 환경과 경쟁력 있는 연봉을 제공합니다.', '010-3456-7891', 75000000, '2023-06-01', '브랜드 매니저 채용', 'user13'),
	(51, '서울', '2년 이상', '2024-07-31', '대학 졸업', '경력', 2, '마케팅', '콘텐츠 마케팅 전문가', '저희 회사는 콘텐츠 중심의 마케팅 전략을 통해 시장을 선도하는 기업으로, 콘텐츠 마케팅 전문가를 모집합니다. 주요 업무는 블로그, 소셜 미디어 등 다양한 채널을 통한 콘텐츠 기획 및 제작입니다. 콘텐츠 마케팅 경험이 풍부한 분을 찾고 있으며, 창의적이고 전략적인 사고를 가진 분을 우대합니다. 도전적인 환경에서 함께 성장할 수 있는 기회를 드립니다.', '010-3456-7892', 65000000, '2023-06-01', '콘텐츠 마케팅 전문가 모집', 'user13'),
	(52, '서울', '3년 이상', '2023-07-15', '대학 졸업', '경력', 1, '마케팅', '디지털 광고 전문가', '저희 회사는 데이터 기반의 디지털 광고 전략을 수립하고 실행하는 기업으로, 디지털 광고 전문가를 모집합니다. 주요 업무는 온라인 광고 캠페인 기획 및 운영, 광고 성과 분석입니다. Google Ads, Facebook Ads 등에 능숙한 분을 찾고 있으며, 데이터 분석을 통해 광고 성과를 개선할 수 있는 분을 우대합니다. 도전적인 환경에서 함께 성장할 수 있는 기회를 드립니다.', '010-3456-7893', 68000000, '2023-06-01', '디지털 광고 전문가 채용', 'user13'),
	(53, '서울', '5년 이상', '2024-06-30', '석사', '경력', 3, '데이터', '데이터 분석가', '저희 회사는 데이터 기반의 비즈니스 인사이트를 제공하는 선도 기업으로, 데이터 분석가를 모집합니다. 주요 업무는 데이터 분석 및 시각화, 비즈니스 인사이트 도출입니다. Python, R 등에 능숙한 분을 찾고 있으며, 데이터 시각화 도구 사용 경험이 있는 분을 우대합니다. 자율적인 근무 환경과 뛰어난 복지 혜택을 제공하며, 글로벌 시장에서 함께 성장할 수 있는 기회를 드립니다.', '010-4567-8901', 80000000, '2023-06-01', '데이터 분석가 채용', 'user14'),
	(54, '서울', '3년 이상', '2024-07-15', '석사', '경력', 2, '데이터', '머신러닝 엔지니어', '저희 회사는 머신러닝 기술을 활용한 혁신적인 솔루션을 제공하는 기업으로, 머신러닝 엔지니어를 모집합니다. 주요 업무는 머신러닝 모델 개발 및 배포입니다. Python, TensorFlow, Keras 등에 능숙한 분을 찾고 있으며, 대규모 데이터셋 처리 경험이 있는 분을 우대합니다. 창의적이고 도전적인 환경에서 함께 성장할 수 있는 기회를 드립니다.', '010-4567-8902', 85000000, '2023-06-01', '머신러닝 엔지니어 모집', 'user14'),
	(55, '서울', '3년 이상', '2024-07-31', '대학 졸업', '경력', 2, '데이터', '데이터 엔지니어', '저희 회사는 데이터 인프라 구축 및 관리를 전문으로 하는 기업으로, 데이터 엔지니어를 모집합니다. 주요 업무는 데이터 파이프라인 설계 및 데이터베이스 관리입니다. SQL, Hadoop, Spark 등에 능숙한 분을 찾고 있으며, 클라우드 환경에서의 데이터 처리 경험이 있는 분을 우대합니다. 자율적인 근무 환경과 경쟁력 있는 연봉을 제공합니다.', '010-4567-8903', 70000000, '2023-06-01', '데이터 엔지니어 채용', 'user14'),
	(56, '서울', '5년 이상', '2023-07-15', '석사', '경력', 1, '데이터', '빅데이터 전문가', '저희 회사는 빅데이터 분석을 통한 비즈니스 혁신을 주도하는 기업으로, 빅데이터 전문가를 모집합니다. 주요 업무는 대규모 데이터셋의 수집, 처리 및 분석입니다. Hadoop, Spark, Kafka 등에 능숙한 분을 찾고 있으며, 빅데이터 플랫폼 경험이 있는 분을 우대합니다. 유연한 근무 환경과 높은 연봉을 제공하며, 데이터 기반의 혁신을 이끌어갈 수 있는 기회를 드립니다.', '010-4567-8904', 90000000, '2023-06-01', '빅데이터 전문가 모집', 'user14'),
	(57, '서울', '3년 이상', '2024-06-30', '대학 졸업', '경력', 2, '기계', '기계 엔지니어', '저희 회사는 첨단 기술을 활용한 기계 설계 및 제조를 전문으로 하는 기업으로, 기계 엔지니어를 모집합니다. 주요 업무는 기계 부품 설계 및 제작, 성능 개선입니다. AutoCAD, SolidWorks 등에 능숙한 분을 찾고 있으며, 기계 공학 분야에서의 경험이 있는 분을 우대합니다. 자율적인 근무 환경과 경쟁력 있는 연봉을 제공합니다.', '010-5678-9012', 65000000, '2023-06-01', '기계 엔지니어 모집', 'user15'),
	(58, '서울', '5년 이상', '2024-07-15', '석사', '경력', 2, '기계', '로봇 엔지니어', '저희 회사는 로봇 공학 기술을 활용한 혁신적인 솔루션을 제공하는 기업으로, 로봇 엔지니어를 모집합니다. 주요 업무는 로봇 시스템 설계 및 개발, 로봇 제어 알고리즘 개발입니다. MATLAB, Simulink 등에 능숙한 분을 찾고 있으며, 로봇 공학 분야에서의 경험이 있는 분을 우대합니다. 창의적이고 도전적인 환경에서 함께 성장할 수 있는 기회를 드립니다.', '010-5678-9013', 75000000, '2023-06-01', '로봇 엔지니어 채용', 'user15'),
	(59, '서울', '2년 이상', '2023-07-31', '대학 졸업', '경력', 1, '기계', '기계 설계 엔지니어', '저희 회사는 고도화된 기계 설계 및 제조 기술을 보유한 기업으로, 기계 설계 엔지니어를 모집합니다. 주요 업무는 기계 설계 도면 작성 및 3D 모델링입니다. CAD, CATIA 등에 능숙한 분을 찾고 있으며, 기계 설계 경험이 있는 분을 우대합니다. 유연한 근무 환경과 높은 연봉을 제공하며, 기계 설계의 혁신을 이끌어갈 수 있는 기회를 드립니다.', '010-5678-9014', 60000000, '2024-06-01', '기계 설계 엔지니어 채용', 'user15'),
	(60, '서울', '신입', '2023-07-15', '대학 졸업', '신입', 1, '기계', '제품 엔지니어', '저희 회사는 혁신적인 제품 설계 및 제조를 전문으로 하는 기업으로, 제품 엔지니어를 모집합니다. 주요 업무는 제품 설계 및 개발, 프로토타입 제작입니다. AutoCAD, SolidWorks 등에 능숙한 분을 찾고 있으며, 신입 지원자도 환영합니다. 창의적이고 도전적인 환경에서 함께 성장할 수 있는 기회를 드립니다.', '010-5678-9015', 55000000, '2023-06-01', '제품 엔지니어 채용', 'user15'),
	(61, '서울', '신입', '2024-06-30', '대학 졸업', '신입', 2, '콘텐츠', '콘텐츠 크리에이터', '저희 회사는 창의적인 콘텐츠 제작을 통해 다양한 미디어 플랫폼에서 활동하는 기업으로, 콘텐츠 크리에이터를 모집합니다. 주요 업무는 동영상 콘텐츠 기획 및 제작, 소셜 미디어 운영입니다. 영상 편집 도구에 능숙한 분을 찾고 있으며, 창의적인 아이디어를 가진 분을 우대합니다. 자유로운 근무 환경과 다양한 복지 혜택을 제공합니다.', '010-6789-0123', 50000000, '2023-06-01', '콘텐츠 크리에이터 모집', 'user16'),
	(62, '서울', '2년 이상', '2024-06-30', '대학 졸업', '경력', 2, '콘텐츠', '영상 편집자', '저희 회사는 고퀄리티 영상 콘텐츠 제작을 전문으로 하는 기업으로, 영상 편집자를 모집합니다. 주요 업무는 촬영된 영상의 편집 및 후반 작업입니다. Adobe Premiere, After Effects 등에 능숙한 분을 찾고 있으며, 다양한 편집 경험이 있는 분을 우대합니다. 자율적인 근무 환경과 경쟁력 있는 연봉을 제공합니다.', '010-6789-0124', 55000000, '2023-06-01', '영상 편집자 채용', 'user16'),
	(63, '서울', '3년 이상', '2024-07-15', '대학 졸업', '경력', 1, '콘텐츠', '프로듀서', '저희 회사는 혁신적인 콘텐츠 제작을 주도하는 기업으로, 프로듀서를 모집합니다. 주요 업무는 콘텐츠 기획 및 제작, 제작팀 관리입니다. 프로젝트 관리 및 제작 경험이 풍부한 분을 찾고 있으며, 창의적이고 리더십을 가진 분을 우대합니다. 창의적이고 도전적인 환경에서 함께 성장할 수 있는 기회를 드립니다.', '010-6789-0125', 65000000, '2023-06-01', '프로듀서 채용', 'user16'),
	(64, '서울', '2년 이상', '2023-07-31', '대학 졸업', '경력', 1, '콘텐츠', '방송 작가', '저희 회사는 다양한 방송 콘텐츠 제작을 전문으로 하는 기업으로, 방송 작가를 모집합니다. 주요 업무는 방송 대본 작성 및 콘텐츠 기획입니다. 창의적인 글쓰기 능력을 가진 분을 찾고 있으며, 방송 작가 경험이 있는 분을 우대합니다. 유연한 근무 환경과 높은 연봉을 제공하며, 콘텐츠 제작의 혁신을 이끌어갈 수 있는 기회를 드립니다.', '010-6789-0126', 60000000, '2023-06-01', '방송 작가 채용', 'user16'),
	(65, '서울', '2년 이상', '2024-06-30', '대학 졸업', '경력', 3, '정보기술', '웹 개발자', '저희 회사는 웹 애플리케이션 개발을 전문으로 하는 IT 기업으로, 웹 개발자를 모집합니다. 주요 업무는 웹 애플리케이션의 개발 및 유지보수입니다. HTML, CSS, JavaScript 등에 능숙한 분을 찾고 있으며, 프론트엔드 또는 백엔드 개발 경험이 있는 분을 우대합니다. 자율적인 근무 환경과 다양한 복지 혜택을 제공합니다.', '010-7890-1234', 65000000, '2023-06-01', '웹 개발자 모집', 'user17'),
	(66, '서울', '3년 이상', '2024-06-30', '대학 졸업', '경력', 2, '정보기술', '모바일 앱 개발자', '저희 회사는 혁신적인 모바일 애플리케이션을 개발하는 IT 기업으로, 모바일 앱 개발자를 모집합니다. 주요 업무는 iOS 및 Android 앱 개발 및 유지보수입니다. Swift, Kotlin 등에 능숙한 분을 찾고 있으며, 모바일 앱 개발 경험이 있는 분을 우대합니다. 창의적이고 도전적인 환경에서 함께 성장할 수 있는 기회를 드립니다.', '010-7890-1235', 70000000, '2023-06-01', '모바일 앱 개발자 채용', 'user17'),
	(67, '서울', '5년 이상', '2024-07-15', '석사', '경력', 1, '데이터', '데이터 엔지니어', '저희 회사는 데이터 인프라 구축 및 관리를 전문으로 하는 기업으로, 데이터 엔지니어를 모집합니다. 주요 업무는 데이터 파이프라인 설계 및 데이터베이스 관리입니다. SQL, Hadoop, Spark 등에 능숙한 분을 찾고 있으며, 클라우드 환경에서의 데이터 처리 경험이 있는 분을 우대합니다. 자율적인 근무 환경과 경쟁력 있는 연봉을 제공합니다.', '010-7890-1236', 80000000, '2023-06-01', '데이터 엔지니어 채용', 'user17'),
	(68, '서울', '3년 이상', '2023-07-31', '대학 졸업', '경력', 2, '정보기술', '시스템 엔지니어', '저희 회사는 IT 인프라 설계 및 관리를 전문으로 하는 기업으로, 시스템 엔지니어를 모집합니다. 주요 업무는 서버 및 네트워크 관리, 시스템 최적화입니다. Linux, Windows 서버 관리 경험이 있는 분을 찾고 있으며, 시스템 보안에 대한 이해가 있는 분을 우대합니다. 유연한 근무 환경과 높은 연봉을 제공하며, 시스템 관리의 혁신을 이끌어갈 수 있는 기회를 드립니다.', '010-7890-1237', 75000000, '2023-06-01', '시스템 엔지니어 채용', 'user17'),
	(69, '서울', '5년 이상', '2024-06-30', '석사', '경력', 3, '경영', '경영 컨설턴트', '저희 회사는 경영 전략 수립 및 실행을 지원하는 선도 기업으로, 경영 컨설턴트를 모집합니다. 주요 업무는 기업의 경영 전략 분석 및 개선 방안 제시입니다. 경영 컨설팅 경험이 풍부한 분을 찾고 있으며, 전략적 사고와 문제 해결 능력을 가진 분을 우대합니다. 자율적인 근무 환경과 경쟁력 있는 연봉을 제공합니다.', '010-8901-2345', 90000000, '2023-06-01', '경영 컨설턴트 채용', 'user18'),
	(70, '서울', '3년 이상', '2024-06-30', '대학 졸업', '경력', 2, '경영', '프로젝트 매니저', '저희 회사는 다양한 프로젝트를 성공적으로 이끄는 기업으로, 프로젝트 매니저를 모집합니다. 주요 업무는 프로젝트 기획 및 실행, 팀 관리입니다. 프로젝트 관리 경험이 풍부한 분을 찾고 있으며, 리더십과 조직 관리 능력을 가진 분을 우대합니다. 창의적이고 도전적인 환경에서 함께 성장할 수 있는 기회를 드립니다.', '010-8901-2346', 75000000, '2023-06-01', '프로젝트 매니저 채용', 'user18'),
	(71, '서울', '2년 이상', '2024-07-15', '대학 졸업', '경력', 2, '경영', '재무 분석가', '저희 회사는 재무 전략 수립 및 실행을 지원하는 선도 기업으로, 재무 분석가를 모집합니다. 주요 업무는 기업의 재무 상태 분석 및 개선 방안 제시입니다. 재무 분석 경험이 풍부한 분을 찾고 있으며, 전략적 사고와 문제 해결 능력을 가진 분을 우대합니다. 자율적인 근무 환경과 경쟁력 있는 연봉을 제공합니다.', '010-8901-2347', 70000000, '2023-06-01', '재무 분석가 채용', 'user18'),
	(72, '서울', '3년 이상', '2023-07-31', '대학 졸업', '경력', 1, '경영', '비즈니스 애널리스트', '저희 회사는 비즈니스 전략 분석 및 실행을 지원하는 선도 기업으로, 비즈니스 애널리스트를 모집합니다. 주요 업무는 기업의 비즈니스 프로세스 분석 및 개선 방안 제시입니다. 비즈니스 분석 경험이 풍부한 분을 찾고 있으며, 전략적 사고와 문제 해결 능력을 가진 분을 우대합니다. 유연한 근무 환경과 높은 연봉을 제공하며, 비즈니스 혁신을 이끌어갈 수 있는 기회를 드립니다.', '010-8901-2348', 80000000, '2023-06-01', '비즈니스 애널리스트 채용', 'user18'),
	(73, '서울', '5년 이상', '2024-06-30', '박사', '경력', 3, '데이터', '데이터 사이언티스트', '저희 회사는 데이터 분석을 통한 비즈니스 혁신을 주도하는 기업으로, 데이터 사이언티스트를 모집합니다. 주요 업무는 데이터 분석 및 머신러닝 모델 개발입니다. Python, R 등에 능숙한 분을 찾고 있으며, 데이터 분석 및 모델링 경험이 풍부한 분을 우대합니다. 자율적인 근무 환경과 뛰어난 복지 혜택을 제공하며, 글로벌 시장에서 함께 성장할 수 있는 기회를 드립니다.', '010-9012-3456', 95000000, '2023-06-01', '데이터 사이언티스트 모집', 'user19'),
	(74, '서울', '3년 이상', '2024-06-30', '석사', '경력', 2, '데이터', '데이터 엔지니어', '저희 회사는 데이터 인프라 구축 및 관리를 전문으로 하는 기업으로, 데이터 엔지니어를 모집합니다. 주요 업무는 데이터 파이프라인 설계 및 데이터베이스 관리입니다. SQL, Hadoop, Spark 등에 능숙한 분을 찾고 있으며, 클라우드 환경에서의 데이터 처리 경험이 있는 분을 우대합니다. 자율적인 근무 환경과 경쟁력 있는 연봉을 제공합니다.', '010-9012-3457', 80000000, '2023-06-01', '데이터 엔지니어 채용', 'user19'),
	(75, '서울', '4년 이상', '2024-07-15', '석사', '경력', 2, '데이터', '빅데이터 분석가', '저희 회사는 빅데이터 분석을 통한 비즈니스 혁신을 주도하는 기업으로, 빅데이터 분석가를 모집합니다. 주요 업무는 대규모 데이터셋의 분석 및 인사이트 도출입니다. Hadoop, Spark, Kafka 등에 능숙한 분을 찾고 있으며, 빅데이터 플랫폼 경험이 있는 분을 우대합니다. 창의적이고 도전적인 환경에서 함께 성장할 수 있는 기회를 드립니다.', '010-9012-3458', 85000000, '2023-06-01', '빅데이터 분석가 채용', 'user19'),
	(76, '서울', '2년 이상', '2023-07-31', '대학 졸업', '경력', 2, '데이터', '데이터 분석가', '저희 회사는 데이터 분석을 통한 비즈니스 혁신을 주도하는 기업으로, 데이터 분석가를 모집합니다. 주요 업무는 데이터 분석 및 시각화, 비즈니스 인사이트 도출입니다. Python, R 등에 능숙한 분을 찾고 있으며, 데이터 시각화 도구 사용 경험이 있는 분을 우대합니다. 자율적인 근무 환경과 뛰어난 복지 혜택을 제공하며, 글로벌 시장에서 함께 성장할 수 있는 기회를 드립니다.', '010-9012-3459', 70000000, '2023-06-01', '데이터 분석가 모집', 'user19'),
	(77, '서울', '신입', '2024-06-30', '대학 졸업', '신입', 2, '디자인', '그래픽 디자이너', '저희 회사는 혁신적인 디자인 솔루션을 제공하는 기업으로, 그래픽 디자이너를 모집합니다. 주요 업무는 브랜드 아이덴티티 디자인 및 각종 마케팅 자료 제작입니다. Adobe Photoshop, Illustrator 등에 능숙한 분을 찾고 있으며, 창의적인 아이디어를 시각적으로 구현할 수 있는 분을 우대합니다. 자율적인 근무 환경과 다양한 복지 혜택을 제공합니다.', '010-0123-4567', 50000000, '2023-06-01', '그래픽 디자이너 모집', 'user20'),
	(78, '서울', '2년 이상', '2024-06-30', '대학 졸업', '경력', 2, '디자인', 'UI/UX 디자이너', '저희 회사는 사용자 중심의 디자인을 추구하는 선도 기업으로, UI/UX 디자이너를 모집합니다. 주요 업무는 모바일 및 웹 애플리케이션의 사용자 인터페이스 설계 및 개선입니다. Adobe XD, Sketch 등에 능숙한 분을 찾고 있으며, 사용자 경험에 대한 깊은 이해를 가진 분을 우대합니다. 창의적이고 도전적인 환경에서 함께 성장할 수 있는 기회를 드립니다.', '010-0123-4568', 55000000, '2023-06-01', 'UI/UX 디자이너 채용', 'user20'),
	(79, '서울', '3년 이상', '2024-07-15', '대학 졸업', '경력', 1, '디자인', '모션 그래픽 디자이너', '저희 회사는 창의적인 비주얼 콘텐츠를 제작하는 선도 기업으로, 모션 그래픽 디자이너를 모집합니다. 주요 업무는 광고 및 프로모션 비디오의 모션 그래픽 제작입니다. After Effects, Cinema 4D 등에 능숙한 분을 찾고 있으며, 다양한 비디오 편집 경험이 있는 분을 우대합니다. 창의적이고 활기찬 환경에서 함께 성장할 수 있는 기회를 드립니다.', '010-0123-4569', 60000000, '2023-06-01', '모션 그래픽 디자이너 모집', 'user20'),
	(80, '서울', '5년 이상', '2023-07-31', '대학 졸업', '경력', 2, '디자인', '브랜드 디자이너', '저희 회사는 강력한 브랜드 아이덴티티를 구축하고 있는 글로벌 기업으로, 브랜드 디자이너를 모집합니다. 주요 업무는 브랜드 전략 수립 및 실행, 브랜드 캠페인 관리입니다. 브랜드 관리 및 디자인 경험이 풍부한 분을 찾고 있으며, 창의적인 아이디어를 실현할 수 있는 분을 우대합니다. 자율적인 근무 환경과 경쟁력 있는 연봉을 제공합니다.', '010-0123-4570', 70000000, '2023-06-01', '브랜드 디자이너 채용', 'user20');

-- 테이블 jobbingsoo.posting_skill 구조 내보내기
CREATE TABLE IF NOT EXISTS `posting_skill` (
  `ps_code` bigint(20) NOT NULL AUTO_INCREMENT,
  `stack` varchar(255) DEFAULT NULL,
  `post_code` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ps_code`),
  KEY `FKhpgn8kov3u1ekgbcwp4ccej6w` (`post_code`),
  CONSTRAINT `FKhpgn8kov3u1ekgbcwp4ccej6w` FOREIGN KEY (`post_code`) REFERENCES `posting` (`post_code`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 jobbingsoo.posting_skill:~0 rows (대략적) 내보내기
DELETE FROM `posting_skill`;
INSERT INTO `posting_skill` (`ps_code`, `stack`, `post_code`) VALUES
	(1, 'Java', 1),
	(2, 'Spring Framework', 1),
	(3, 'MySQL', 1),
	(4, 'React', 2),
	(5, 'Vue.js', 2),
	(6, 'HTML/CSS', 2),
	(7, 'AWS', 3),
	(8, 'Docker', 3),
	(9, 'Kubernetes', 3),
	(10, 'Python', 4),
	(11, 'R', 4),
	(12, 'TensorFlow', 4),
	(13, 'Adobe XD', 5),
	(14, 'Sketch', 5),
	(15, 'Figma', 5),
	(16, 'Adobe Photoshop', 6),
	(17, 'Adobe Illustrator', 6),
	(18, 'InDesign', 6),
	(19, 'After Effects', 7),
	(20, 'Cinema 4D', 7),
	(21, 'Premiere Pro', 7),
	(22, 'Google Analytics', 8),
	(23, 'Facebook Ads', 8),
	(24, 'SEO', 8),
	(25, 'Google Analytics', 9),
	(26, 'SEO', 9),
	(27, 'Content Marketing', 9),
	(28, 'Brand Management', 10),
	(29, 'Marketing Strategy', 10),
	(30, 'Advertising', 10),
	(31, 'Content Creation', 11),
	(32, 'Social Media Marketing', 11),
	(33, 'SEO', 11),
	(34, 'Google Ads', 12),
	(35, 'Facebook Ads', 12),
	(36, 'Data Analysis', 12),
	(37, 'Python', 13),
	(38, 'R', 13),
	(39, 'Data Visualization', 13),
	(40, 'Python', 14),
	(41, 'TensorFlow', 14),
	(42, 'Keras', 14),
	(43, 'SQL', 15),
	(44, 'Hadoop', 15),
	(45, 'Spark', 15),
	(46, 'Hadoop', 16),
	(47, 'Spark', 16),
	(48, 'Kafka', 16),
	(49, 'AutoCAD', 17),
	(50, 'SolidWorks', 17),
	(51, 'MATLAB', 17),
	(52, 'MATLAB', 18),
	(53, 'Simulink', 18),
	(54, 'ROS', 18),
	(55, 'CAD', 19),
	(56, 'CATIA', 19),
	(57, '3D Modeling', 19),
	(58, 'AutoCAD', 20),
	(59, 'SolidWorks', 20),
	(60, 'Prototyping', 20),
	(61, 'Video Editing', 21),
	(62, 'Content Creation', 21),
	(63, 'Social Media Marketing', 21),
	(64, 'Premiere Pro', 22),
	(65, 'After Effects', 22),
	(66, 'Final Cut Pro', 22),
	(67, 'Project Management', 23),
	(68, 'Team Leadership', 23),
	(69, 'Content Production', 23),
	(70, 'Creative Writing', 24),
	(71, 'Script Writing', 24),
	(72, 'Content Planning', 24),
	(73, 'HTML', 25),
	(74, 'CSS', 25),
	(75, 'JavaScript', 25),
	(76, 'Swift', 26),
	(77, 'Kotlin', 26),
	(78, 'React Native', 26),
	(79, 'SQL', 27),
	(80, 'Hadoop', 27),
	(81, 'Spark', 27),
	(82, 'Linux', 28),
	(83, 'Windows Server', 28),
	(84, 'Network Security', 28),
	(85, 'Business Strategy', 29),
	(86, 'Problem Solving', 29),
	(87, 'Analytical Thinking', 29),
	(88, 'Project Management', 30),
	(89, 'Leadership', 30),
	(90, 'Team Coordination', 30),
	(91, 'Financial Analysis', 31),
	(92, 'Strategic Planning', 31),
	(93, 'Risk Management', 31),
	(94, 'Business Analysis', 32),
	(95, 'Process Improvement', 32),
	(96, 'Data Analysis', 32),
	(97, 'Python', 33),
	(98, 'R', 33),
	(99, 'Machine Learning', 33),
	(100, 'SQL', 34),
	(101, 'Hadoop', 34),
	(102, 'Spark', 34),
	(103, 'Hadoop', 35),
	(104, 'Spark', 35),
	(105, 'Kafka', 35),
	(106, 'Python', 36),
	(107, 'R', 36),
	(108, 'Data Visualization', 36),
	(109, 'Adobe Photoshop', 37),
	(110, 'Adobe Illustrator', 37),
	(111, 'InDesign', 37),
	(112, 'Adobe XD', 38),
	(113, 'Sketch', 38),
	(114, 'Figma', 38),
	(115, 'After Effects', 39),
	(116, 'Cinema 4D', 39),
	(117, 'Premiere Pro', 39),
	(118, 'Brand Management', 40),
	(119, 'Marketing Strategy', 40),
	(120, 'Creative Design', 40);

-- 테이블 jobbingsoo.red_bean 구조 내보내기
CREATE TABLE IF NOT EXISTS `red_bean` (
  `rb_code` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `birth` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `military` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `rid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rb_code`),
  KEY `FKd4cnl477p90jv55kjxckrwd4u` (`rid`),
  CONSTRAINT `FKd4cnl477p90jv55kjxckrwd4u` FOREIGN KEY (`rid`) REFERENCES `member` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 jobbingsoo.red_bean:~10 rows (대략적) 내보내기
DELETE FROM `red_bean`;
INSERT INTO `red_bean` (`rb_code`, `address`, `birth`, `email`, `gender`, `military`, `name`, `tel`, `rid`) VALUES
	(1, '서울특별시 강남구 삼성로 123', '1990-01-01', 'user1@example.com', '남', '전역', '홍길동', '010-1234-5678', 'user1'),
	(2, '부산광역시 해운대구 해운로 456', '1992-02-02', 'user2@example.com', '여', '면제', '김영희', '010-2345-6789', 'user2'),
	(3, '대구광역시 수성구 수성로 789', '1991-03-03', 'user3@example.com', '남', '미필', '이철수', '010-3456-7890', 'user3'),
	(4, '인천광역시 부평구 부평로 101', '1993-04-04', 'user4@example.com', '여', '면제', '박미영', '010-4567-8901', 'user4'),
	(5, '광주광역시 남구 남구로 202', '1990-05-05', 'user5@example.com', '남', '전역', '최진호', '010-5678-9012', 'user5'),
	(6, '대전광역시 서구 서대로 303', '1989-06-06', 'user6@example.com', '여', '면제', '강수지', '010-6789-0123', 'user6'),
	(7, '울산광역시 북구 북구로 404', '1988-07-07', 'user7@example.com', '남', '전역', '윤민혁', '010-7890-1234', 'user7'),
	(8, '세종특별자치시 세종로 505', '1994-08-08', 'user8@example.com', '여', '면제', '한민정', '010-8901-2345', 'user8'),
	(9, '경기도 성남시 분당구 분당로 606', '1987-09-09', 'user9@example.com', '남', '미필', '정우성', '010-9012-3456', 'user9'),
	(10, '충청북도 청주시 상당구 상당로 707', '1995-10-10', 'user10@example.com', '여', '면제', '오나래', '010-0123-4567', 'user10');

-- 테이블 jobbingsoo.resume 구조 내보내기
CREATE TABLE IF NOT EXISTS `resume` (
  `resume_code` bigint(20) NOT NULL AUTO_INCREMENT,
  `desired_pay` int(11) DEFAULT NULL,
  `edu_major` varchar(255) DEFAULT NULL,
  `edu_name` varchar(255) DEFAULT NULL,
  `edu_state` date DEFAULT NULL,
  `edu_type` varchar(255) DEFAULT NULL,
  `employmemt_type` varchar(255) DEFAULT NULL,
  `graduate_date` varchar(255) DEFAULT NULL,
  `photo_url` varchar(255) DEFAULT NULL,
  `public_type` char(1) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `rid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`resume_code`),
  KEY `FKqufym59v4gbe5g4igbykgqr75` (`rid`),
  CONSTRAINT `FKqufym59v4gbe5g4igbykgqr75` FOREIGN KEY (`rid`) REFERENCES `member` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 jobbingsoo.resume:~20 rows (대략적) 내보내기
DELETE FROM `resume`;
INSERT INTO `resume` (`resume_code`, `desired_pay`, `edu_major`, `edu_name`, `edu_state`, `edu_type`, `employmemt_type`, `graduate_date`, `photo_url`, `public_type`, `title`, `rid`) VALUES
	(1, 50000000, '컴퓨터공학', '서울대학교', NULL, '학사', '경력', '2014-02-25', 'photos/user1_1.jpg', 'T', '소프트웨어 엔지니어 이력서', 'user1'),
	(2, 48000000, '컴퓨터공학', '서울대학교', NULL, '학사', '경력', '2014-02-25', 'photos/user1_2.jpg', 'F', '백엔드 개발자 이력서', 'user1'),
	(3, 40000000, '시각디자인', '홍익대학교', NULL, '학사', '신입', '2016-02-25', 'photos/user2_1.jpg', 'T', '디자이너 이력서', 'user2'),
	(4, 38000000, '시각디자인', '홍익대학교', NULL, '학사', '신입', '2016-02-25', 'photos/user2_2.jpg', 'F', 'UI/UX 디자이너 이력서', 'user2'),
	(5, 45000000, '경영학', '고려대학교', NULL, '학사', '경력', '2015-02-25', 'photos/user3_1.jpg', 'T', '마케팅 전문가 이력서', 'user3'),
	(6, 43000000, '경영학', '고려대학교', NULL, '학사', '경력', '2015-02-25', 'photos/user3_2.jpg', 'F', '광고 기획자 이력서', 'user3'),
	(7, 60000000, '통계학', '연세대학교', NULL, '석사', '경력', '2017-02-25', 'photos/user4_1.jpg', 'T', '데이터 사이언티스트 이력서', 'user4'),
	(8, 58000000, '통계학', '연세대학교', NULL, '석사', '경력', '2017-02-25', 'photos/user4_2.jpg', 'F', '데이터 엔지니어 이력서', 'user4'),
	(9, 55000000, '기계공학', '한양대학교', NULL, '학사', '경력', '2013-02-25', 'photos/user5_1.jpg', 'T', '기계 엔지니어 이력서', 'user5'),
	(10, 53000000, '기계공학', '한양대학교', NULL, '학사', '경력', '2013-02-25', 'photos/user5_2.jpg', 'F', '로봇 엔지니어 이력서', 'user5'),
	(11, 38000000, '영화학', '중앙대학교', NULL, '학사', '신입', '2018-02-25', 'photos/user6_1.jpg', 'T', '콘텐츠 크리에이터 이력서', 'user6'),
	(12, 36000000, '영화학', '중앙대학교', NULL, '학사', '신입', '2018-02-25', 'photos/user6_2.jpg', 'F', '영상 제작자 이력서', 'user6'),
	(13, 52000000, '컴퓨터공학', '서강대학교', NULL, '학사', '경력', '2012-02-25', 'photos/user7_1.jpg', 'T', '웹 개발자 이력서', 'user7'),
	(14, 50000000, '컴퓨터공학', '서강대학교', NULL, '학사', '경력', '2012-02-25', 'photos/user7_2.jpg', 'F', '프론트엔드 개발자 이력서', 'user7'),
	(15, 47000000, '경영학', '이화여자대학교', NULL, '학사', '신입', '2019-02-25', 'photos/user8_1.jpg', 'T', '프로젝트 매니저 이력서', 'user8'),
	(16, 45000000, '경영학', '이화여자대학교', NULL, '학사', '신입', '2019-02-25', 'photos/user8_2.jpg', 'F', '경영 컨설턴트 이력서', 'user8'),
	(17, 48000000, '산업공학', '서울과학기술대학교', NULL, '학사', '경력', '2016-02-25', 'photos/user9_1.jpg', 'T', '데이터 분석가 이력서', 'user9'),
	(18, 46000000, '산업공학', '서울과학기술대학교', NULL, '학사', '경력', '2016-02-25', 'photos/user9_2.jpg', 'F', '비즈니스 분석가 이력서', 'user9'),
	(19, 42000000, '시각디자인', '경희대학교', NULL, '학사', '신입', '2020-02-25', 'photos/user10_1.jpg', 'T', '그래픽 디자이너 이력서', 'user10'),
	(20, 40000000, '시각디자인', '경희대학교', NULL, '학사', '신입', '2020-02-25', 'photos/user10_2.jpg', 'F', '브랜드 디자이너 이력서', 'user10');

-- 테이블 jobbingsoo.resume_skill 구조 내보내기
CREATE TABLE IF NOT EXISTS `resume_skill` (
  `skill_code` bigint(20) NOT NULL AUTO_INCREMENT,
  `stack` varchar(255) DEFAULT NULL,
  `resume_code` bigint(20) DEFAULT NULL,
  `rid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`skill_code`),
  KEY `FKae35e1gxtp1614ckuhi0l8dga` (`resume_code`),
  KEY `FKdmwi7j0i7jlhcynron44ajjwf` (`rid`),
  CONSTRAINT `FKae35e1gxtp1614ckuhi0l8dga` FOREIGN KEY (`resume_code`) REFERENCES `resume` (`resume_code`),
  CONSTRAINT `FKdmwi7j0i7jlhcynron44ajjwf` FOREIGN KEY (`rid`) REFERENCES `member` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 jobbingsoo.resume_skill:~60 rows (대략적) 내보내기
DELETE FROM `resume_skill`;
INSERT INTO `resume_skill` (`skill_code`, `stack`, `resume_code`, `rid`) VALUES
	(1, 'Java', 1, 'user1'),
	(2, 'Spring', 1, 'user1'),
	(3, 'MySQL', 1, 'user1'),
	(4, 'Node.js', 2, 'user1'),
	(5, 'Express.js', 2, 'user1'),
	(6, 'MongoDB', 2, 'user1'),
	(7, 'Adobe Photoshop', 3, 'user2'),
	(8, 'Adobe Illustrator', 3, 'user2'),
	(9, 'Sketch', 3, 'user2'),
	(10, 'Figma', 4, 'user2'),
	(11, 'Adobe XD', 4, 'user2'),
	(12, 'InVision', 4, 'user2'),
	(13, 'Google Analytics', 5, 'user3'),
	(14, 'SEO', 5, 'user3'),
	(15, 'Content Marketing', 5, 'user3'),
	(16, 'AdWords', 6, 'user3'),
	(17, 'Campaign Management', 6, 'user3'),
	(18, 'Brand Strategy', 6, 'user3'),
	(19, 'Python', 7, 'user4'),
	(20, 'R', 7, 'user4'),
	(21, 'TensorFlow', 7, 'user4'),
	(22, 'Hadoop', 8, 'user4'),
	(23, 'Spark', 8, 'user4'),
	(24, 'SQL', 8, 'user4'),
	(25, 'AutoCAD', 9, 'user5'),
	(26, 'SolidWorks', 9, 'user5'),
	(27, 'MATLAB', 9, 'user5'),
	(28, 'CATIA', 10, 'user5'),
	(29, 'ANSYS', 10, 'user5'),
	(30, 'Simulink', 10, 'user5'),
	(31, 'Final Cut Pro', 11, 'user6'),
	(32, 'Adobe Premiere Pro', 11, 'user6'),
	(33, 'After Effects', 11, 'user6'),
	(34, 'Avid Media Composer', 12, 'user6'),
	(35, 'DaVinci Resolve', 12, 'user6'),
	(36, 'Cinema 4D', 12, 'user6'),
	(37, 'HTML', 13, 'user7'),
	(38, 'CSS', 13, 'user7'),
	(39, 'JavaScript', 13, 'user7'),
	(40, 'React', 14, 'user7'),
	(41, 'Vue.js', 14, 'user7'),
	(42, 'Angular', 14, 'user7'),
	(43, 'Project Management', 15, 'user8'),
	(44, 'Agile Methodologies', 15, 'user8'),
	(45, 'Scrum', 15, 'user8'),
	(46, 'Strategic Planning', 16, 'user8'),
	(47, 'Business Analysis', 16, 'user8'),
	(48, 'Change Management', 16, 'user8'),
	(49, 'SQL', 17, 'user9'),
	(50, 'Tableau', 17, 'user9'),
	(51, 'Power BI', 17, 'user9'),
	(52, 'SAS', 18, 'user9'),
	(53, 'SPSS', 18, 'user9'),
	(54, 'Excel', 18, 'user9'),
	(55, 'Adobe Photoshop', 19, 'user10'),
	(56, 'CorelDRAW', 19, 'user10'),
	(57, 'SketchUp', 19, 'user10'),
	(58, 'Adobe Illustrator', 20, 'user10'),
	(59, 'InDesign', 20, 'user10'),
	(60, 'Blender', 20, 'user10');

-- 테이블 jobbingsoo.star_point 구조 내보내기
CREATE TABLE IF NOT EXISTS `star_point` (
  `star_code` bigint(20) NOT NULL,
  `point` int(11) DEFAULT NULL,
  `cid` varchar(255) DEFAULT NULL,
  `rid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`star_code`),
  KEY `FK8ay509o3ajv6ih22vhaw0mpi3` (`cid`),
  KEY `FKorvigvru69q6o70pbf627mhqd` (`rid`),
  CONSTRAINT `FK8ay509o3ajv6ih22vhaw0mpi3` FOREIGN KEY (`cid`) REFERENCES `member` (`username`),
  CONSTRAINT `FKorvigvru69q6o70pbf627mhqd` FOREIGN KEY (`rid`) REFERENCES `member` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 jobbingsoo.star_point:~0 rows (대략적) 내보내기
DELETE FROM `star_point`;

-- 테이블 jobbingsoo.subscribe 구조 내보내기
CREATE TABLE IF NOT EXISTS `subscribe` (
  `subs_code` bigint(20) NOT NULL AUTO_INCREMENT,
  `cid` varchar(255) DEFAULT NULL,
  `rid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`subs_code`),
  KEY `FK7a0crlxdouvh5cw56rye0r7o` (`cid`),
  KEY `FK6inv2oa9ot1imf9nrah5v2b6q` (`rid`),
  CONSTRAINT `FK6inv2oa9ot1imf9nrah5v2b6q` FOREIGN KEY (`rid`) REFERENCES `member` (`username`),
  CONSTRAINT `FK7a0crlxdouvh5cw56rye0r7o` FOREIGN KEY (`cid`) REFERENCES `member` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 jobbingsoo.subscribe:~0 rows (대략적) 내보내기
DELETE FROM `subscribe`;

-- 테이블 jobbingsoo.sub_category 구조 내보내기
CREATE TABLE IF NOT EXISTS `sub_category` (
  `sccode` bigint(20) NOT NULL,
  `sub` varchar(255) DEFAULT NULL,
  `mccode` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`sccode`),
  KEY `FKa0cvabdy9b3ffqcyt93hix9ds` (`mccode`),
  CONSTRAINT `FKa0cvabdy9b3ffqcyt93hix9ds` FOREIGN KEY (`mccode`) REFERENCES `main_category` (`mccode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 jobbingsoo.sub_category:~83 rows (대략적) 내보내기
DELETE FROM `sub_category`;
INSERT INTO `sub_category` (`sccode`, `sub`, `mccode`) VALUES
	(1, '01. 사업관리', 1),
	(2, '01. 기획사무', 2),
	(3, '02. 총무·인사', 2),
	(4, '03. 재무·회계', 2),
	(5, '04. 생산·품질관리', 2),
	(6, '01. 금융', 3),
	(7, '02. 보험', 3),
	(8, '01. 학교교육', 4),
	(9, '02. 평생교육', 4),
	(10, '03. 직업교육', 4),
	(11, '01. 법률', 5),
	(12, '02. 소방방재', 5),
	(13, '01. 보건', 6),
	(14, '02. 의료', 6),
	(15, '01. 사회복지', 7),
	(16, '02. 상담', 7),
	(17, '03. 보육', 7),
	(18, '01. 문화·예술', 8),
	(19, '02. 디자인', 8),
	(20, '03. 문화콘텐츠', 8),
	(21, '01. 자동차운전·운송', 9),
	(22, '02. 철도운전·운송', 9),
	(23, '03. 선박운전·운송', 9),
	(24, '04. 항공운전·운송', 9),
	(25, '01. 영업', 10),
	(26, '02. 부동산', 10),
	(27, '03. 판매', 10),
	(28, '01. 경비', 11),
	(29, '02. 청소', 11),
	(30, '01. 이·미용', 12),
	(31, '02. 결혼·장례', 12),
	(32, '03. 관광·레저', 12),
	(33, '04. 스포츠', 12),
	(34, '01. 식음료조리·서비스', 13),
	(35, '01. 건설공사관리', 14),
	(36, '02. 토목', 14),
	(37, '03. 건축', 14),
	(38, '04. 플랜트', 14),
	(39, '05. 조경', 14),
	(40, '06. 도시·교통', 14),
	(41, '07. 건설기계운전·정비 ', 14),
	(42, '08. 해양자원', 14),
	(43, '01. 기계설계', 15),
	(44, '02. 기계가공', 15),
	(45, '03. 기계조립', 15),
	(46, '04. 기계품질관리', 15),
	(47, '05. 기계장치설치', 15),
	(48, '06. 자동차', 15),
	(49, '07. 철도차량제작', 15),
	(50, '08. 조선', 15),
	(51, '09. 항공기제작', 15),
	(52, '10. 금형', 15),
	(53, '11. 스마트공장', 15),
	(54, '01. 금속재료', 16),
	(55, '02. 세라믹재료', 16),
	(56, '01. 화학·바이오공통', 17),
	(57, '02. 석유·기초화학물', 17),
	(58, '03. 정밀화확', 17),
	(59, '04. 플라스틱·고무', 17),
	(60, '05. 바이오', 17),
	(61, '01. 섬유제조', 18),
	(62, '02. 패션', 18),
	(63, '03. 의복관리', 18),
	(64, '01. 전기', 19),
	(65, '02. 전자기기일반', 19),
	(66, '03. 전자기기개발', 19),
	(67, '01. 정보기술', 20),
	(68, '02. 통신기술', 20),
	(69, '03. 방송기술', 20),
	(70, '01. 식품가공', 21),
	(71, '02. 제과·제빵·떡제조', 21),
	(72, '01. 인쇄·출판', 22),
	(73, '02. 공예', 22),
	(74, '01. 산업환경', 23),
	(75, '02. 환경보건', 23),
	(76, '03. 자연환경', 23),
	(77, '04. 환경서비스', 23),
	(78, '05. 에너지·자원', 23),
	(79, '06. 산업안전보고', 23),
	(80, '01. 농업', 24),
	(81, '02. 축산', 24),
	(82, '03. 임업', 24),
	(83, '04. 수산', 24);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
