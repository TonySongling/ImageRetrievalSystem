package com.hbd.retrieval.search.domain;
/**
 * �ϴ�ͼƬ����Ϣ
 * @author Edward
 *
 */
public class ImageInfo {
	//������λ
	private int positionFlag;
	//�����������Ͻ�����X
	private int leftTopX;
	//�����������Ͻ�����Y
	private int leftTopY;
	//�����������±�����X
	private int rightBottomX;
	//�����������½�����Y
	private int rightBottomY;
	
	public int getPositionFlag() {
		return positionFlag;
	}
	public void setPositionFlag(int positionFlag) {
		this.positionFlag = positionFlag;
	}
	public int getLeftTopX() {
		return leftTopX;
	}
	public void setLeftTopX(int leftTopX) {
		this.leftTopX = leftTopX;
	}
	public int getLeftTopY() {
		return leftTopY;
	}
	public void setLeftTopY(int leftTopY) {
		this.leftTopY = leftTopY;
	}
	public int getRightBottomX() {
		return rightBottomX;
	}
	public void setRightBottomX(int rightBottomX) {
		this.rightBottomX = rightBottomX;
	}
	public int getRightBottomY() {
		return rightBottomY;
	}
	public void setRightBottomY(int rightBottomY) {
		this.rightBottomY = rightBottomY;
	}
	
}
