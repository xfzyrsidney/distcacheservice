package com.sidney.dbsyncserver.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.thrift.TException;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TIOStreamTransport;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.TTransportFactory;

public class TServlet extends HttpServlet {
	protected TProcessor processor_ = null;
	protected TTransportFactory inputTransportFactory_ = new TTransportFactory();
	protected TTransportFactory outputTransportFactory_ = new TTransportFactory();
	protected TProtocolFactory inputProtocolFactory_ = new TBinaryProtocol.Factory();
	protected TProtocolFactory outputProtocolFactory_ = new TBinaryProtocol.Factory();

	public TServlet(TProcessor processor)
	{
		processor_ = processor;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter w = response.getWriter();
		w.write("This is a thrift service!");
		w.close();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("application/x-thrift");
		InputStream in = request.getInputStream();
		OutputStream out = response.getOutputStream();
		TTransport client = new TIOStreamTransport(in, out);
		TProcessor processor = null;
		TTransport inputTransport = null;
		TTransport outputTransport = null;
		TProtocol inputProtocol = null;
		TProtocol outputProtocol = null;
		try
		{
			processor = processor_;
			inputTransport = inputTransportFactory_.getTransport(client);
			outputTransport = outputTransportFactory_.getTransport(client);
			inputProtocol = inputProtocolFactory_.getProtocol(inputTransport);
			outputProtocol = outputProtocolFactory_.getProtocol(outputTransport);
			while (processor.process(inputProtocol, outputProtocol))
			{
			}
		} catch (TTransportException ttx)
		{
			// Client died, just move on
		} catch (TException tx)
		{
			tx.printStackTrace();
		} catch (Exception x)
		{
			x.printStackTrace();
		}
		if (inputTransport != null)
		{
			inputTransport.close();
		}
		if (outputTransport != null)
		{
			outputTransport.close();
		}
	}
}
