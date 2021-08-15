import { CarDetail } from "./CarDetail";
import { UserDetail } from "./UserDetail";

export class LoanDetail{
    loanId : number;
    applyDate: Date;
    approval: string;
    emi: number;
    existingEmi: number;
    principalAmount: number;
    rateOfInterest: number;
    tenure: number;
    carDetail: CarDetail;
    userDetail: UserDetail
}