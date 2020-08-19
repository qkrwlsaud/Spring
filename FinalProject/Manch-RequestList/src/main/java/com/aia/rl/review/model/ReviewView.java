package com.aia.rl.review.model;

import java.util.List;


public class ReviewView {

	// 전체 리스트 수
	private int listTotalCnt;

	// 전체 페이지의 개수
	private int pageTotalCount;

	// 페이지 당 표현 할 정보 개수 - 상수
	private int requestCountPage;

	// 현재 페이지의 번호
	private int currentPageNum;

	// 출력 할 리뷰 
	private List<Review> reviewList;

	// 게시물의 시작 행
	private int startRow;
	

	public ReviewView(int listTotalCnt, int requestCountPage, int currentPageNum, List<Review> reviewList,
			int startRow) {
		this.listTotalCnt = listTotalCnt;
		this.requestCountPage = requestCountPage;
		this.currentPageNum = currentPageNum;
		this.reviewList = reviewList;
		this.startRow = startRow;
		calTotalCount();
	}

	// 전체 페이지를 구하는 메소드
	private void calTotalCount() {
		if (listTotalCnt == 0) {
			pageTotalCount = 0;
		} else {
			pageTotalCount = listTotalCnt / requestCountPage;
			if (listTotalCnt % requestCountPage > 0) {
				pageTotalCount++;
			}

		}
	}

	public int getListTotalCnt() {
		return listTotalCnt;
	}

	public void setListTotalCnt(int listTotalCnt) {
		this.listTotalCnt = listTotalCnt;
	}

	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public void setPageTotalCount(int pageTotalCount) {
		this.pageTotalCount = pageTotalCount;
	}

	public int getRequestCountPage() {
		return requestCountPage;
	}

	public void setRequestCountPage(int requestCountPage) {
		this.requestCountPage = requestCountPage;
	}

	public int getCurrentPageNum() {
		return currentPageNum;
	}

	public void setCurrentPageNum(int currentPageNum) {
		this.currentPageNum = currentPageNum;
	}

	public List<Review> getRequestReg() {
		return reviewList;
	}

	public void setRequestReg(List<Review> reviewList) {
		this.reviewList = reviewList;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	@Override
	public String toString() {
		return "RequestRegView [listTotalCnt=" + listTotalCnt + ", pageTotalCount=" + pageTotalCount
				+ ", requestCountPage=" + requestCountPage + ", currentPageNum=" + currentPageNum + ", requestReg="
				+ reviewList + ", startRow=" + startRow + "]";
	}

	
	


}
