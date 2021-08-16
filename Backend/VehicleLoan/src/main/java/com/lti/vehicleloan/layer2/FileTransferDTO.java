package com.lti.vehicleloan.layer2;

import org.springframework.web.multipart.MultipartFile;

public class FileTransferDTO {
	private MultipartFile aadharCard;
	private MultipartFile panCard;
	private MultipartFile photo;
	private MultipartFile salarySlip;
	
	public MultipartFile getAadharCard() {
		return aadharCard;
	}
	public void setAadharCard(MultipartFile aadharCard) {
		this.aadharCard = aadharCard;
	}
	public MultipartFile getPanCard() {
		return panCard;
	}
	public void setPanCard(MultipartFile panCard) {
		this.panCard = panCard;
	}
	public MultipartFile getPhoto() {
		return photo;
	}
	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	public MultipartFile getSalarySlip() {
		return salarySlip;
	}
	public void setSalarySlip(MultipartFile salarySlip) {
		this.salarySlip = salarySlip;
	}
	
	
}
