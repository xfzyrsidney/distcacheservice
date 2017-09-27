package com.sidney.dbsyncserver.servlet;

import org.apache.thrift.protocol.TBinaryProtocol;

import com.sidney.dbsyncserver.syncinstance.MasterSync;
import com.sidney.dbsyncserver.syncinstance.SlaveSync;
import com.sidney.dbsyncserver.syncinterface.IMaster;
import com.sidney.dbsyncserver.syncinterface.ISlave;

import org.apache.thrift.server.TServlet;

public class DbSyncSlaveServiceServlet extends TServlet {  
    public DbSyncSlaveServiceServlet() {  
        super(new ISlave.Processor(new SlaveSync()), new TBinaryProtocol.Factory()); 
    }  
}  