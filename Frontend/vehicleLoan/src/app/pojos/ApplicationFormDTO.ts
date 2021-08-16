import { AdvancedUserDetail } from "./AdvancedUserDetail";
import { CarDetail } from "./CarDetail";
import { EmploymentDetail } from "./EmploymentDetail";
import { LoanDetail } from "./LoanDetail";
import { UserDetail } from "./UserDetail";

export class ApplicationFormDTO{
    userDetail: UserDetail;
    carDetail: CarDetail;
	employmentDetail: EmploymentDetail;
	loanDetail: LoanDetail;
	advancedUserDetail: AdvancedUserDetail;

}