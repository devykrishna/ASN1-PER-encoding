/*
 *   openASN.1 - an open source ASN.1 toolkit for java
 *
 *   Copyright (C) 2007 Clayton Hoss, Marc Weyland
 *
 *   This file is part of openASN.1
 *
 *   openASN.1 is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU Lesser General Public License as 
 *   published by the Free Software Foundation, either version 3 of 
 *   the License, or (at your option) any later version.
 *
 *   openASN.1 is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *   GNU Lesser General Public License for more details.
 *
 *   You should have received a copy of the GNU Lesser General Public License
 *   along with openASN.1. If not, see <http://www.gnu.org/licenses/>.
 * 
 */




import java.util.List;
import java.util.ArrayList;
/**
 * @author Marc Weylan
 *
 */

import Telematics.om.*;


import java.util.List;
import java.util.ArrayList;
/**
 * @author Marc Weylan
 *
 */
abstract public class DataModelRepository {
	public static Telematics basicRecord() { 
		Telematics telematics  = new Telematics();
		Header header = new Header();
        Body body = new Body();
        Basic basic = new Basic();
        TimeStamp timestamp = new TimeStamp();
		long fix = 2L;
		long time  = 3708609262288L;
		
		timestamp.setTimeStamp(time);
		Position position = new Position();
		position.setLatitude(32337.0);
		position.setLongitude(5204.0);
		position.setAltitude(23382.0);
		position.setHeading(31008.0);
		position.setFix(fix);		
		MilElement milelement = new MilElement();
		List <MilElement> mils = new ArrayList<MilElement>();
        milelement.setMil(MilCode.oilPressure);
        milelement.setStatus(MilStatus.warning);
        mils.add(milelement); 
        Running running = new Running();
		/*Event event = new Event();
		Maintenance maintenance = new Maintenance();
		Diagnostics diagnostics = new Diagnostics();
		DrivingBehavior drivingbehavior = new DrivingBehavior();
		DrivingSafety drivingsafety = new DrivingSafety();
		Running running = new Running();
		
		TimeStamp timestamp = new TimeStamp();
		long fix = 2L;
		long time  = 1696255925430L;					
		timestamp.setTimeStamp(time);
		Position position = new Position();
		position.setLatitude(32337.0);
		position.setLongitude(5204.0);
		position.setAltitude(23382.0);
		position.setHeading(31008.0);
		position.setFix(fix);		
		MilElement milelement = new MilElement();
		List <MilElement> mils = new ArrayList<>();
        milelement.setMil(MilCode.fuelLevel);
        milelement.setStatus(MilStatus.highRisk);
        mils.add(milelement);       
		ECUDiagnostic ecu = new ECUDiagnostic();
		DiagnosticTroubleCode dtc = new DiagnosticTroubleCode();
        List<DiagnosticTroubleCode> eculs = new ArrayList<>();
        dtc.setDtc("dtcstring");
        dtc.setDtcAdvice("dtcadvice");
        dtc.setDtcDesc("dtcdecsription");
        dtc.setFailureBatteryVoltage(45.0);
        dtc.setFailureVehicleSpeed(46.0);
        dtc.setFirstFail(timestamp);
        dtc.setLastFail(timestamp);
        dtc.setOdometer(108L);
        dtc.setOdoStatus(OdoStatus.obd);
        dtc.setPosition(position);
        dtc.setStatus(DtcStatus.confirmedDTC);
		ecu.setDiagnosticResult(HealthStatus.ok);
		eculs.add(dtc);
		ecu.setDtcs(eculs);
		ecu.setEcuID("ecuid");
		ecu.setExceptionCode(12L);
		Behaviours behav = new Behaviours();
		behav.setAccelerating(null);
		behav.setBraking(null);
		behav.setCornering(null);
		behav.setEngineOnWithoutDriver(null);
		behav.setExcessSpeeding(null);
		behav.setFatiguedDriving(null);
		behav.setForwardCollision(null);
		behav.setHarshLaneChanging(null);
		behav.setHarshOvertaking(null);
		behav.setHarshRPM(null);
		behav.setLaneDeparture(null);
		behav.setOverRevving(null);
		behav.setOverSafeHeadway(null);
		behav.setPedestrianCollision(null);
		behav.setSpeedbreakerBump(null);
		BatteryStatus batterystatus = new BatteryStatus();
		batterystatus.setChargeLevel(ChargeLevel.full);
		batterystatus.setStateOfCharge(StateOfCharge.alternated);
		batterystatus.setStateOfHealth(StateOfHealth.normal);
		batterystatus.setVoltage(24.0);	
		
		EventPayload eventpayload = new EventPayload();
		
		Accident accident = new Accident();
		accident.setOdometer(61.0);
		accident.setPosition(position);
		accident.setSpeed(60.0);
		eventpayload.setAccident(accident);
		
		AlarmTrigger alarmtrigger = new AlarmTrigger();
		alarmtrigger.setDriverId("driverid");
		alarmtrigger.setDriverName("Drivername");
		alarmtrigger.setOdometer(61.0);
		alarmtrigger.setPosition(position);
		alarmtrigger.setSpeed(60.0);
		eventpayload.setDriverAlarmTrigger(alarmtrigger);
		
		DriverStatus driverstatus = new DriverStatus();
		driverstatus.setDriverId("driverid");
		driverstatus.setDriverName("drivername");
		driverstatus.setPosition(position);
		eventpayload.setDriverLogin(driverstatus);
		eventpayload.setDriverLogout(driverstatus);
		
		IrregularDriving irregulardriving = new IrregularDriving();
		irregulardriving.setDriverId("driverid");
		irregulardriving.setDriverName("drivername");
		irregulardriving.setOdometer(61.0);
		irregulardriving.setSpeed(60.0);
		irregulardriving.setStatusCode(69L);
		eventpayload.setIrregularDriving(irregulardriving);
		
		IrregularHWAccessed  hwaccess = new IrregularHWAccessed();
		hwaccess.setDeviceId("deviceid");
		hwaccess.setPosition(position);
		hwaccess.setReason("reason");
		eventpayload.setIrregularHWAccessed(hwaccess);
		
		eventpayload.setPassengerAlarmTrigger(alarmtrigger);
		
		PassengerOff passengeroff = new PassengerOff();
		passengeroff.setCompanyName("companyname");
		passengeroff.setCustomerName("customername");
		passengeroff.setCustomerPhoneNum("customerphonenumber");
		passengeroff.setDriverIdNum("driverid");
		passengeroff.setDriverLicenseNum("license");
		passengeroff.setDriverPhoneNum("driverphonenum");
		passengeroff.setPassengerCount(28L);
		passengeroff.setPassengerStatus("passengerstatus");
		passengeroff.setPosition(position);
		eventpayload.setPassengerOff(passengeroff);
		
		PassengerOn passengeron = new PassengerOn();
		passengeron.setCompanyName("companyname");
		passengeron.setCustomerName("customername");
		passengeron.setCustomerPhoneNum("customerphonenumber");
		passengeron.setDriverIdNum("driverid");
		passengeron.setDriverLicenseNum("license");
		passengeron.setDriverPhoneNum("driverphonenum");
		passengeron.setPassengerCount(28L);
		passengeron.setPassengerStatus("passengerstatus");
		passengeron.setPosition(position);		
		eventpayload.setPassengerOn(passengeron);
		
		Theft theft = new Theft();
		theft.setOdometer(61.0);
		theft.setPosition(position);
		eventpayload.setTheft(theft);
		
		TripEnd tripend = new TripEnd();
		tripend.setAverageFuelConsumption(56.0);
		tripend.setAverageSpeed(67L);
		tripend.setCo2(78L);
		Customer customer = new Customer();
		customer.setPassengerCount(78L);
		
		List<Passengers> passengerlist = new ArrayList<>();
		Passengers pass = new Passengers();
		pass.setContact(Contact.contact);
		pass.setCustomerName("customername");
		pass.setCustomerPhoneNum("customerphonenumber");
		passengerlist.add(pass);
		customer.setPassengers(passengerlist);
		customer.setPassengerStatus("passengerstatus");
		tripend.setCustomer(customer);
		tripend.setDistance(566L);
		List<Driver> driverlist = new ArrayList<>();
		Driver driver = new Driver();
		driver.setDisplayName("driverdisplayname");
		driver.setDriverId("driverid");
		driver.setGender("drivergender");
		driver.setIdCardNo("driveridacrd");
		driver.setDriverLicenseNum("driverlicense");
        driverlist.add(driver);
		tripend.setDriver(driverlist);
		tripend.setEndPosition(position);
		tripend.setEndTime("endtime");
		tripend.setEnterpriseName("enterprisename");
		Fare fare =new Fare();
		fare.setAmount(45.5);
		fare.setDistanceCharge(45.0);
		fare.setExtras(8.8);
		fare.setRate(67.0);
		fare.setStartFare(68.9);
		fare.setTax(56.7);
		fare.setTimeCharge(56.9);
		fare.setTips(90.0);
		fare.setTollways(34.9);
		fare.setUnit("fareunit");
		tripend.setFare(fare);
		tripend.setFuelConsumption(68.0);
		tripend.setIdleTime(6789L);
		tripend.setMaxSpeed(69L);
		tripend.setOdometer(61L);
		tripend.setPaymentType("paramtype");
		List<SalikPasses> saliklist = new ArrayList<>();
		SalikPasses salik = new SalikPasses();
		List<Double> cordlist = new ArrayList<>();
		cordlist.add(30.0);
		salik.setCoordinate(cordlist);
		salik.setPassTime("passtime");
		salik.setSalikId("salikid");
		saliklist.add(salik);
		tripend.setSalikPasses(saliklist);
		tripend.setStartPosition(position);
		tripend.setStartTime("9:00:00");
		tripend.setTripTime(123456L);
		tripend.setType(Type.journey);
		eventpayload.setTripEnd(tripend);
		TripStart tripstart =new TripStart();
		tripstart.setCustomer(customer);   
		tripstart.setDriver(driverlist);
		tripstart.setEnterpriseName("enterpricename");
		tripstart.setOdometer(60L);
		tripstart.setStartPosition(position);
		tripstart.setStartTime("starttime");
		tripstart.setType(Type.trip);
		eventpayload.setTripStart(tripstart);
		
        basic.setDirection(109L);
        basic.setDistanceToEmpty(11678L);
        basic.setEngineBlockedStatus(EngineBlockedStatus.allowedToStart);
        basic.setEngineStatus(EngineStatus.off);
        basic.setFuel(23.0);
        basic.setKeyStatus(KeyStatus.inserted);
        basic.setMils(mils);
        basic.setOdometer(878L);
        basic.setPosition(position);
        basic.setSpeed(23.0);
        basic.setTimeStamp(timestamp);
        basic.setUsageMode(null);
        
        diagnostics.setEcuDiagnositcs(ecu);
        diagnostics.setTimeStamp(timestamp);
        
        drivingbehavior.setBehaviours(behav);
        drivingbehavior.setBrakePedalDepressed(null);
        drivingbehavior.setCruiseControlStatus(null);
        drivingbehavior.setEngineSpeed(null);
        drivingbehavior.setTimeStamp(timestamp);
        drivingbehavior.setTransimissionGearPostion(null);
        
        drivingsafety.setCentralLockingStatus(null);
        drivingsafety.setDoorLockStatusDriver(null);
        drivingsafety.setDoorLockStatusDriverRear(null);
        drivingsafety.setDoorLockStatusPassenger(null);
        drivingsafety.setDoorLockStatusPassengerRear(null);
        drivingsafety.setDoorOpenStatusDriver(null);
        drivingsafety.setDoorOpenStatusDriverRear(null);
        drivingsafety.setDoorOpenStatusPassenger(null);
        drivingsafety.setDoorOpenStatusPassengerRear(null);
        drivingsafety.setElectricParkBrakeStatus(ElectricParkBrakeStatus.inProgress);
        drivingsafety.setEngineHoodOpenStatus(null);
        drivingsafety.setHandBrakeStatus(null);
        drivingsafety.setSeatBeltStatusDriver(null);
        drivingsafety.setSeatBeltStatusDriverRear(null);
        drivingsafety.setSeatBeltStatusPassenger(null);
        drivingsafety.setSeatBeltStatusPassengerRear(null);
        drivingsafety.setSrsStatus(null);
        drivingsafety.setTimeStamp(timestamp);
        drivingsafety.setTrunkOpenStatus(null);
        
        event.setDescription("eventdecsription");
        event.setEventPayload(eventpayload);
        event.setId(new IdString("DT354394490022257"));
        event.setName("eventname");
        event.setTimestamp(timestamp);
        event.setType("eventtype");
        
        maintenance.setBrakeFluidLevelStatus(BrakeFluidLevelStatus.high);
        maintenance.setDaysToService(30.0);
        maintenance.setDistanceToService(31.0);
        maintenance.setEngineHrsToService(32.0);
        maintenance.setMainBatteryStatus(batterystatus);
        maintenance.setServiceWarningStatus(WarningStatus.almostTime);
        maintenance.setServiceWarningTrigger(ServiceWarningTrigger.disabled);
        maintenance.setTimeStamp(timestamp);
        maintenance.setTyrePreWarningDriver(WarningLevel.normal);
        maintenance.setTyrePreWarningDriverRear(WarningLevel.normal);
        maintenance.setTyrePreWarningPassenger(WarningLevel.normal);
        maintenance.setTyrePreWarningPassengerRear(WarningLevel.warning);
        maintenance.setTyreStatusDriver(35.0);
        maintenance.setTyreStatusDriverRear(36.0);
        maintenance.setTyreStatusPassenger(37.0);
        maintenance.setTyreStatusPassengerRear(38.0);
        maintenance.setWasherFluidLevelStatus(WasherFluidLevelStatus.low);
       */ 
        running.setAveFuelConsumption(null);
        running.setAveFuelConsumptionInLatestDrivingCycle(null);
        running.setAvgRunningSpeed(null);
        running.setBulbStatus(null);
        running.setEngineCoolantLevelStatus(null);
        running.setEngineCoolantTemperature(null);
        running.setEngineOilLevelStatus(null);
        running.setEngineOilPressureWarning(null);
        running.setEngineOilTemperature(null);
        running.setFuelLevel(null);
        running.setFuelLevelStatus(FuelLevelStatus.low);
        running.setFuelLevel(0.0);
        time  =  6360362544054L;		
		timestamp.setTimeStamp(time);
        running.setTimeStamp(timestamp);
        
		header.setAckRequired(true);
		header.setImei("ROa");
		header.setImsi("ERKQt99");
		header.setMsisdn("VFTC");
		header.setRequestid(new IdString("Z"));
		header.setTimeStamp(timestamp);
		header.setVin("52bYH2");
		
		basic.setDirection(109L);
        basic.setDistanceToEmpty(11678L);
        basic.setEngineBlockedStatus(EngineBlockedStatus.forbiddenToStart);
        basic.setEngineStatus(EngineStatus.unknown);
        basic.setFuel(5704.0);
        basic.setKeyStatus(KeyStatus.notInserted);
        basic.setMils(mils);
        basic.setOdometer(80L);
        basic.setPosition(position);
        basic.setSpeed(0.0);
		time  = 6360362544054L;		
		timestamp.setTimeStamp(time);
        basic.setTimeStamp(timestamp);
        basic.setUsageMode(UsageMode.odometerFromVehicle);
		
		body.setBasic(basic);
	/*	body.setDiagnostics(diagnostics);
		body.setDrivingBehavior(drivingbehavior);
		body.setDrivingSafety(drivingsafety);
		body.setEvent(event);
		body.setMaintenance(maintenance);*/
		body.setRunning(running);
		
        telematics.setBody(body);
        telematics.setHeader(header);
        
        return telematics;	

}
}
