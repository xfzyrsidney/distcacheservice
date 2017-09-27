package com.sidney.dbsyncserver.servlet;

import com.sidney.dbsyncserver.syncinstance.MasterSync;
import com.sidney.dbsyncserver.syncinterface.IMaster;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TServlet;

public class DbSyncMasterServiceServlet extends TServlet {  
    public DbSyncMasterServiceServlet() {  
        super(new IMaster.Processor(new MasterSync()), new TBinaryProtocol.Factory());  
    }  
}  