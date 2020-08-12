package com.aia.rl.service;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.rl.LocationDistance;
import com.aia.rl.dao.RequestDao;
import com.aia.rl.model.RequestReg;

@Service
public class RequestListService {

	private RequestDao dao;

	@Autowired
	private SqlSessionTemplate template;

	public List<RequestReg> requestList() {

		dao = template.getMapper(RequestDao.class);

		List<RequestReg> requestAll = dao.selectAllList(); //전체 리스트 
		List<RequestReg> requestResult = new ArrayList<RequestReg>(); //계산된 요청글을 담을 리스트
		RequestReg request = null; // 요청글 한개
		
		for (int i = 0; i < requestAll.size(); i++) {
			
			request = new RequestReg(requestAll.get(i).getReqIdx(),
					requestAll.get(i).getReqWriter(),
					requestAll.get(i).getReqTitle(),
					requestAll.get(i).getReqHelper(),
					requestAll.get(i).getReqDateTime(),
					requestAll.get(i).getReqAddr(),
					requestAll.get(i).getReqContents(),
					requestAll.get(i).getReqLatitude(),
					requestAll.get(i).getReqLongitude(),
					requestAll.get(i).getReqCount(),
					requestAll.get(i).getReqStatus(),
					requestAll.get(i).getReqImg()
					);
			
			double reqLoc = Double.parseDouble(requestAll.get(i).getReqLatitude());
			double reqLon = Double.parseDouble(requestAll.get(i).getReqLongitude());

			LocationDistance locDistance = new LocationDistance();

			// 두 거리 계산 결과 meter로 출력
			int distance = locDistance.distance(37.5674160717181, 126.966305052144, reqLoc, reqLon);
			
			// 사용자가 요청한 거리 만큼 
			int userDist = 2000;
			if (distance <= userDist) {
				request.setDistance(distance); //한개의 요청글에 거리를 담는다
				requestResult.add(request);
			} 
		}
		
		return requestResult;

	}

}