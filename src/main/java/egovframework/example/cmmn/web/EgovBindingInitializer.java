/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package egovframework.example.cmmn.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

/**
 * @Class Name : EgovBindingInitializer.java
 * @Description : EgovBindingInitializer Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2009.03.16           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2009. 03.16
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */

/* 부모는 선언만 하며, 반드시 자식이 정의를 오버라이딩해서 사용
 * extends: 클래스 한 개만 상속 받을 수 있으며, 자식 클래스는 부모 클래스의 기능을 사용
 * implements: 여러 개의 interface를 상속 받을 수 있으며, 자식 클래스는 부모의 기능을 다시 정의해서 사용해야함.
 */
public class EgovBindingInitializer implements WebBindingInitializer {

	/**
	* initBinder
	* @param binder
	* @param request
	* @see 개발프레임웍크 실행환경 개발팀
	*/
	@Override
	public void initBinder(WebDataBinder binder) {
		// 날짜 형식 변환 등록
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
		dateFormat.setLenient(false);
		
		// 커스텀 에디터 등록: String -> Date
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		
		// 기타 데이터 바인딩 설정
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
	}

}
