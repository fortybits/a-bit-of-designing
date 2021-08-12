package edu.bit.designing.fulfilment;

/**
 * Task Fulfilment Service
 *
 * Customer Creates Task
 * Predefined Task Categories
 * Online Payment (Before Completion of Task)
 * Live Order Tracking
 *
 *
 *
 * categories=> kind of task
 *
 * Task [destination, task categories,
 *
 * agent should be aware of payment status
 * taskId => order reached to
 *
 * validate task creations within some area…
 *
 *
 * Customer			Task			Payment			Tracking
 * Source per categories
 *
 *
 *
 * TaskModule [ createTask | generateTransactionId | generateTrackingId | generateDelieveryId ]
 *
 * PaymentModule [ currentPaymentStatus ]
 *
 * TrackingModule [ generateTrackingId | currentTrackingStatus | pathOfAgent ]
 *
 * CatalogueModule [ fetchSourcesPerCategory |  ]
 *
 * DeliveryModule [ startTask(assignAgentToTask) | endTask ]
 *  	assignAgentToTask (pathOfAgent)
 * 		> listNearestAgents : need to find closest to the source
 *
 *
 *
 * Task:
 * taskId
 * taskCategory
 *
 * creatorId
 *
 * 	sourceId
 * destinationId
 *
 * 	trackingId
 * transactionId
 * deliveryId
 *
 * taskStatus
 *
 * Customer:
 * 	creatorId
 * 	[destinations]
 *
 * Transaction (Payment)
 * 	transactionId
 * 	amount
 * 	currentStatus
 *
 *
 * Tracking
 * 	trackingId
 * 	source
 * 	destination
 * currentLocation
 *
 *
 * CategorySource
 * 	sourceId
 *
 * Delivery
 * 	deliveryId
 * 	agentDetail
 * 	pathFollowed [ ]
 *
 *
 *
 * delivery assignment
 * agent assignment fifo [kormangala]
 * ratings [bellandur]
 *
 *
 *
 *
 * interface DeliveryAssignment {
 *
 * Agent assignAgentToTask(Task task, Location location);
 *
 * Agent bestFit(List<Agent>  agents);
 *
 * }
 *
 * interface AgentsService {
 * List<Agent> getAgentsInLocation(Location location);
 * }
 *
 *
 * class Parent DeliveryAssignment {
 *
 * Agent assignAgentToTask(Task task, Location location);
 *
 * Agent bestFit(List<Agent>  agents);
 *
 * }
 *
 *
 * class FIFODeliveryAssignment implements DA {
 * 	AgentService agentService;
 *
 * 	assignAgentToTask( ) {
 * 		var agents = agentService.getAgentsInLocation();
 * 		return bestFit
 *
 * Agent bestFit(List<Agent>  agents) {
 * // FIFO
 * }
 *
 *
 * }
 * class RatingnsDeliveryAssignment implements DA {
 * 	AgentService agentService;
 *
 * 	assignAgentToTask( ) {
 * 		var agents = agentService.getAgentsInLocation();
 * 		return bestFit
 * }
 *
 * Agent bestFit(List<Agent>  agents) {
 * 	// ratings
 * }
 *
 *
 * }
 */
public class TaskFulfilmentService {
}
