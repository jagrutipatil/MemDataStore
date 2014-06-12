package org.mem.store.persistence.model.listeners;

import org.mem.store.persistence.model.MemoryTuple;

import java.util.EventObject;

// TODO need to make sure the eventObject is immutable
public class TupleRemovedEvent extends EventObject {
	public TupleRemovedEvent(MemoryTuple tuple) {
		super(tuple);
	}
}
