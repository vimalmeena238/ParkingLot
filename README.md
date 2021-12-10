# ParkingLot

## Functional Requirements
1. Admin should be able to view/modify/delete slots.
2. User should be able to park a vehicle and get a ticket for the same.
3. System should support vehicles of twoWheeler and FourWheeler types.
4. User should be able to unpark a vehicle and ticket should be updated as completed.

## Main Entities
1. Vehicle
2. ParkingSlot
3. ParkingTicket

## Entities Relationships
<img src="https://user-images.githubusercontent.com/16173594/145558162-e3fe9f3a-4d81-49c5-ace8-ff33ac68367a.png" 
alt="ParkingLot DB Schema" width="800" height="500" border="10" />

## Rest APIs
Type | endPoint | BodyParameter | Description
---  | ---      | ---           | --- 
GET  | /api/v1/slots | NA | Returns all slots (available/reserved)
POST | /api/v1/slots | ParkingSlot() | Add new slot in inventory and returns id
DEL  | /api/v1/slots/{id} | NA | Delete slot of specified id in path {id}
POST | /api/v1/park | Vehicle() | Park a vehicle and returns ParkingTicket
GET  | /api/v1/unpark/{ticketId} | NA | Unpark a vehicle and mark ticket status complete

