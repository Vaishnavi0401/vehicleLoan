import { CarMaker } from "./CarMaker";
import { CarType } from "./carType";
import { CarType } from "./CarType";


export class CarDetail{
    carId: number;
    carModelImage: string;
    model: string;
    onroadPrice: number;
    showroomPrice: number;
    vehicleDomain: string;
    carMaker: CarMaker;
    carType: CarType;
}