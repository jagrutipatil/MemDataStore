package org.mem.store.persistence.stats;

import org.mem.store.persistence.model.listeners.MemoryTableListener;

public interface MemTableStatsObservable {

	public void registerListener(MemoryTableListener tableListener);

	public void unRegisterListener(MemoryTableListener tableListener);
}
