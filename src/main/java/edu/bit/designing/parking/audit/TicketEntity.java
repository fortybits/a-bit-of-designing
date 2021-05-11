package edu.bit.designing.parking.audit;

/**
 * Entity that can be used for the purpose of auditing of ticket issued by the automated parking system.
 * improvement: plan how to audit and ingest such entities with complete details e.g. issuedAt and returnedAt ingestion
 */
public class TicketEntity {
    long ticketId;
    SlotDetails slotDetails;
    VehicleDetails vehicleDetails;
    long issuedAt;
    long returnedAt;
}