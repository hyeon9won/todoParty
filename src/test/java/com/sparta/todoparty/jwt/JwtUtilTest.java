package com.sparta.todoparty.jwt;

import com.sparta.todoparty.CommonTest;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static com.sparta.todoparty.jwt.JwtUtil.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@SpringBootTest
@ActiveProfiles("test")
class JwtUtilTest implements CommonTest {

    @Autowired
    JwtUtil jwtUtil;

    @Mock
    private HttpServletRequest request;

    @BeforeEach
    void setUp() {
        jwtUtil.init();
    }

    @DisplayName("토큰 생성")
    @Test
    void createToken () {
        // When
        String token = jwtUtil.creatToken(TEST_USER_NAME);

        // Then
        assertNotNull(token);
    }

//    @DisplayName("토큰 추출")
//    @Test
//    void resolveToken() {
//        // G
//        String token = "test-token";
//        String bearerToken = BEARER_PREFIX + token;
//
//        // W
//        given(request.getHeader(JwtUtil.AUTHORIZATION_HEADER)).willReturn(token);
//        String resolvedToken = jwtUtil.resolveToken(request);
//
//        // T
//        assertEquals(token, resolvedToken);
//    }

    @DisplayName("토큰 검증 성공")
    @Test
    void validateToken_success() {
        // G
        String token = jwtUtil.creatToken(TEST_USER_NAME).substring(7);

        // W
        boolean isValid = jwtUtil.validateToken(token);

        // T
        assertTrue(isValid);
    }

    @DisplayName("토큰 검증 실패 - 유효하지 않은 토큰")
    @Test
    void validateToken_fail() {
        // G
        String invaildToken = "invaild-token";

        // W
        boolean isValid = jwtUtil.validateToken(invaildToken);

        // T
        assertFalse(isValid);
    }

//    @DisplayName("토큰에서 UserInfo 조회")
//    @Test
//    void getUserInfoFromToken() {
//        // G
//        String token = jwtUtil.creatToken(TEST_USER_NAME).substring(7);
//
//        // W
//        Claims claims = jwtUtil.getUserInfoFromToken(token);
//
//        // T
//        assertNotNull(claims);
//        assertEquals(TEST_USER_NAME, claims.getSubject());
//    }
}