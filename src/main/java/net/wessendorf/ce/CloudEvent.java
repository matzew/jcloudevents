package net.wessendorf.ce;


import java.net.URI;
import java.util.Date;
import java.util.Map;

/**
 * An abstract event envelope, representing the 0.1 version of the <a href="https://github.com/cloudevents/spec/blob/master/spec.md">CNCF CloudEvent spec</a>.
 *
 */
public interface CloudEvent<T> {
    /**
     * Type of occurrence which has happened. Often this property is used for routing, observability, policy enforcement, etc.
     */
    String getEventType();

    /**
     * The version of the eventType. This enables the interpretation of data by eventual consumers, requires the consumer to be knowledgeable about the producer.
     */
    String getEventTypeVersion();

    /**
     * The version of the CloudEvents specification which the event uses. This enables the interpretation of the context.
     */
    String getCloudEventsVersion();

    /**
     * This describes the event producer. Often this will include information such as the type of the event source, the organization publishing the event, and some unique identifiers.
     * The exact syntax and semantics behind the data encoded in the URI is event producer defined.
     */
    URI getSource();

    /**
     * ID of the event. The semantics of this string are explicitly undefined to ease the implementation of producers. Enables deduplication.
     */
    String getEventID();

    /**
     * Timestamp of when the event happened.
     */
    Date getEventTime();

    /**
     * A link to the schema that the data attribute adheres to.
     */
    URI getSchemaURL();

    /**
     * Describe the data encoding format
     */
    String getContentType();

    /**
     * This is for additional metadata and this does not have a mandated structure. This enables a place for custom fields a producer or middleware might want to include and provides a place to test metadata before adding them to the CloudEvents specification.
     */
    Map getExtensions();

    /**
     * The event payload. The payload depends on the eventType, schemaURL and eventTypeVersion, the payload is encoded into a media format which is specified by the contentType attribute (e.g. application/json).
     */
    T getData();
}
