package com.cos.security1.config.oauth;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService{

	// 구글로부터 받은 userRequest 데이터에 대한 후처리하는 함수
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		System.out.println("userRequest : " + userRequest.getClientRegistration()); // registrationId로 어떤 OAuth로 로그인했는지 확인가능 
		System.out.println("userRequest : " + userRequest.getAccessToken());
		
		// 구글로그인 버튼 클릭 -> 구글로그인 창 -> 로그인을 완료 -> 코드를 리턴 (OAuth -> Client 라이브러리) -> AccessToken 요청
		// UserRequest 정보 -> loadUser 함수 호출 -> 구글로부터 회원 프로필을 받아준다.
		System.out.println("userRequest : " + super.loadUser(userRequest).getAttributes());
		
		OAuth2User oAuth2User = super.loadUser(userRequest);
		// 회원가입 강제로 진행해볼 예정
		return super.loadUser(userRequest);
	}
}
