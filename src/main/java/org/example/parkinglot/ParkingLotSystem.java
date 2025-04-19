package org.example.parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

enum VehicleType{
    SMALL,
    MEDIUM,
    LARGE
}

class Vehicle{
    String licenseNumber;
    VehicleType vehicleType;

    Vehicle(String licenseNumber, VehicleType vehicleType){
        this.licenseNumber=licenseNumber;
        this.vehicleType=vehicleType;
    }

    VehicleType getVehicleType(){
        return vehicleType;
    }

    String getLicenseNumber(){
        return licenseNumber;
    }
}

class ParkingTicket{
    long ticketId;
    ParkingSlot parkingSlot;

    ParkingTicket(long ticketId,ParkingSlot parkingSlot){
        this.ticketId=ticketId;
        this.parkingSlot=parkingSlot;
    }

    long getTicketId(){
        return ticketId;
    }
}

class ParkingSlot{
    long slotId;
    VehicleType slotVehicleType;
    boolean isAvailable=true;

    ParkingSlot(long slotId, VehicleType vehicleType){
        this.slotId=slotId;
        this.slotVehicleType=vehicleType;
    }

    boolean canFit(Vehicle vehicle){
        if (vehicle.getVehicleType()==VehicleType.SMALL){
            return true;
        }
        else if (vehicle.getVehicleType()==VehicleType.MEDIUM ){
            return slotVehicleType==VehicleType.MEDIUM || slotVehicleType==VehicleType.LARGE;

        } else{ //vehicle.getVehicleType()==VehicleType.LARGE
            return slotVehicleType==VehicleType.LARGE;
        }
    }

    boolean parkVehicle(Vehicle vehicle) {
        if (isAvailable && canFit(vehicle)){
            isAvailable=false;
            return true;
        }
        return false;
    }

    boolean unParkVehicle(long slotId){
        if (!isAvailable && slotId==this.slotId){
            isAvailable=true;
            return true;
        }
        return false;
    }
}

class ParkingFloor{
    long floorId;
    List<ParkingSlot> parkingSlots = new ArrayList<>();

    ParkingFloor(long floorId){
        this.floorId=floorId;
    }

    void addParkingSlots(ParkingSlot parkingSlot){
        parkingSlots.add(parkingSlot);
    }
}

class ParkingBuilding{
    long buildingId;
    List<ParkingFloor> parkingFloors = new ArrayList<>();

    ParkingBuilding(long buildingId){
        this.buildingId=buildingId;
    }

    void addParkingFloors(ParkingFloor parkingFloor){
        parkingFloors.add(parkingFloor);
    }
}

class ParkingLot{
    long parkingLotId;
    List<ParkingBuilding> parkingBuildings = new ArrayList<>();

    ParkingLot(long parkingLotId){
        this.parkingLotId=parkingLotId;
    }

    void addParkingBuildings(ParkingBuilding parkingBuilding){
        parkingBuildings.add(parkingBuilding);
    }

}

class ParkingService{

    final HashMap<Long,ParkingSlot> ticket = new HashMap<>();


    void parkVehicle(ParkingLot parkingLot, Vehicle vehicle){
        ParkingSlot parkingSlot = checkAvailableSlots(parkingLot,vehicle);

        if (parkingSlot != null){
            ParkingTicket parkingTicket = new ParkingTicket(123, parkingSlot);
            ticket.put(parkingTicket.getTicketId(), parkingSlot);
            System.out.println("Vehicle has been parked. Ticket ID: " +  parkingTicket.getTicketId());
        }
        else{
            System.out.println("Slot not found!");
        }
    }

     void unParkVehicle(long ticketId){

        if (ticket.containsKey(ticketId)){
            ParkingSlot parkingSlot = ticket.get(ticketId);
            boolean unPark = parkingSlot.unParkVehicle(parkingSlot.slotId);
            if (unPark){
                System.out.println("Vehicle unParked!");
            }
            else{
                System.out.println("Vehicle didn't unPark!");
            }
        }
        else{
            System.out.println("Vehicle not parked!");
        }
    }

     ParkingSlot checkAvailableSlots(ParkingLot parkingLot, Vehicle vehicle){
        for (ParkingBuilding parkingBuilding: parkingLot.parkingBuildings){
            for (ParkingFloor parkingFloor: parkingBuilding.parkingFloors){
                for (ParkingSlot parkingSlot: parkingFloor.parkingSlots){
                    if (parkingSlot.parkVehicle(vehicle)){
                        return parkingSlot;
                    }
                }
            }
        }
        return null;
    }

}

public class ParkingLotSystem {


    public static void main(String[] args){

        Vehicle vehicle = new Vehicle("BA-244",VehicleType.SMALL);

        ParkingSlot parkingSlot1 = new ParkingSlot(1,VehicleType.LARGE);
        ParkingSlot parkingSlot2 = new ParkingSlot(2,VehicleType.SMALL);
        ParkingSlot parkingSlot3 = new ParkingSlot(3,VehicleType.MEDIUM);

        ParkingFloor parkingFloor = new ParkingFloor(1);
        parkingFloor.addParkingSlots(parkingSlot1);
        parkingFloor.addParkingSlots(parkingSlot2);
        parkingFloor.addParkingSlots(parkingSlot3);

        ParkingBuilding parkingBuilding = new ParkingBuilding(1);
        parkingBuilding.addParkingFloors(parkingFloor);

        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.addParkingBuildings(parkingBuilding);

        ParkingService parkingService = new ParkingService();

        parkingService.parkVehicle(parkingLot,vehicle);
        parkingService.unParkVehicle(123);

    }
}




