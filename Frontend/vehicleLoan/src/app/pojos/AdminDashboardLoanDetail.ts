import { CarDetail } from "./CarDetail";
import { UserDetail } from "./UserDetail";

export class AdminDashboardLoanDetail{
    loanId : number;
    applyDate: Date;
    approval: string;
    emi: number;
    existingEmi: number;
    principalAmount: number;
    rateOfInterest: number;
    tenure: number;
    carDetail: CarDetail;
    userDetail: UserDetail;
    /*
    carId: number;
    carModelImage: number;
    model: number;
    onroadPrice:number;
    showroomPrice: number;
    vehicleDomain: number;
    userId: number;
    age:number;
    email: string;
    gender: string;
    mobileNumber: number;
    name: string;
    password: string;
    role: number;
    employeeId: number;
    annualSalary: number;
    */

}