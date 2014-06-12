package org.mem.store.persistence.service.invm;

import org.mem.store.persistence.descriptor.ColumnDescriptor;
import org.mem.store.persistence.descriptor.TableDescriptor;
import org.mem.store.persistence.exceptions.DuplicateColumnException;
import org.mem.store.persistence.exceptions.DuplicateTableException;
import org.mem.store.persistence.exceptions.NoSuchTableException;
import org.mem.store.persistence.model.invm.impl.InMemoryDataStore;
import org.mem.store.persistence.model.listeners.MemoryTableListener;
import org.mem.store.persistence.service.MetadataService;
import org.mem.store.query.model.Predicate;

import java.util.Collection;
import java.util.Iterator;

public class InMemoryMetadataService implements MetadataService {

	/**
	 * Single instance of in memory data store.
	 */
	private InMemoryDataStore<?> inMemoryDataStore = InMemoryDataStore.INSTANCE;

	@Override
	public int getCardinality(String tableName, String columnName) {
		return inMemoryDataStore.getCardinality(tableName, columnName);
	}

	@Override
	public boolean isIndexed(String tableName, String columnName) {
		return inMemoryDataStore.isIndexed(tableName, columnName);
	}

	@Override
	public Iterator<String> getIndexNames(String tableName) {
		return inMemoryDataStore.getAllIndexes(tableName);
	}

    @Override
    public <D extends TableDescriptor<?>> void createTable(D tableDescriptor) throws DuplicateTableException {
        inMemoryDataStore.createTable(tableDescriptor);
    }

    @Override
    public void createIndex(String tableName, ColumnDescriptor columnDescriptor) throws NoSuchTableException, DuplicateColumnException {
        inMemoryDataStore.createIndex(tableName, columnDescriptor);
    }

    @Override
    public void createIndexes(String tableName, Collection<ColumnDescriptor> columnDescriptors) throws NoSuchTableException, DuplicateColumnException {
        inMemoryDataStore.createIndexes(tableName, columnDescriptors);
    }

    @Override
    public boolean deleteTable(String tableName) {
        return inMemoryDataStore.deleteTable(tableName) != null;
    }

    @Override
	public <P extends Predicate> void createJoinTable(String tableName, P predicate) {

	}

	@Override
	public boolean isTableExist(String tableName) {
		return inMemoryDataStore.isTableExist(tableName);
	}

	@Override
	public void registerTableListener(String tableName,
			                          MemoryTableListener tableLisener) {
		inMemoryDataStore.registerTableListener(tableName, tableLisener);
	}
}
