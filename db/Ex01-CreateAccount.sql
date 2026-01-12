-- SQL의 주석

-- 1. 사용자 계정 만들기 (DCL : data control language)
-- 형식 : 사용자명@접속하는 컴퓨터의 IP

CREATE USER human@localhost IDENTIFIED BY "human";
-- CREATE USER human@"192.168.0.*" IDENTIFIED BY "human"; -- 앞 부분이 192.168.0. 인 모든 IP
CREATE USER human@"%" IDENTIFIED BY "human";

-- 2. 사용자에게 권한 부여
-- human 계정에 sakala, world 데이터베이스에 대한 모든 사용 권한 부여 

GRANT ALL PRIVILEGES ON sakila.* TO human@localhost;
GRANT ALL PRIVILEGES ON sakila.* TO human@"%";
GRANT ALL PRIVILEGES ON world.* TO human@localhost;
GRANT ALL PRIVILEGES ON world.* TO human@"%";