package com.sidney.dbsyncserver.tserializ.common;

import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.thrift.TDeserializer;
import org.apache.thrift.TException;
import org.apache.thrift.TSerializer;
import org.apache.thrift.protocol.TBinaryProtocol;

import com.adchina.utils.DateUtil;
import com.sidney.dbsyncserver.dbaccess.admanager.AdManagerContext;
 
import com.sidney.dbsyncserver.dbaccess.dsp.DspContext;
 
import com.sidney.dbsyncserver.syncinterface.BinaryType;
import com.sidney.dbsyncserver.syncmodel.Balance;
import com.sidney.dbsyncserver.syncmodel.BalanceObj;
import com.sidney.dbsyncserver.tserializ.admanager.*;
import com.sidney.dbsyncserver.tserializ.balance.TBalance;
import com.sidney.dbsyncserver.tserializ.balance.TBalanceObj;
import com.sidney.dbsyncserver.tserializ.dsp.*;

public class DbSerializeService
{
	private static final String DATE_STRING_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public DbSerializeService()
	{

	}

	public byte[] serializeToBytes(Object obj, BinaryType deSerialType)
	{
		byte[] serialBytes = null;
		TSerializer serializer = null;
		switch (deSerialType)
		{
			case ADMANAGER:
				AdManagerContext adManagerContext = (AdManagerContext) obj;
				TAdManagerContext tAdManagerContext = new TAdManagerContext();

				deepCopy(adManagerContext, tAdManagerContext);
				serializer = new TSerializer(new TBinaryProtocol.Factory());
				try
				{
					serialBytes = serializer.serialize(tAdManagerContext);
				} catch (TException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
					serialBytes = null;
				}
				break;
			case DSP:
				DspContext dspContext = (DspContext) obj;
				TDspContext tDspContext = new TDspContext();

				deepCopy(dspContext, tDspContext);
				serializer = new TSerializer(new TBinaryProtocol.Factory());
				try
				{
					serialBytes = serializer.serialize(tDspContext);
				} catch (TException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
					serialBytes = null;
				}
				break;
			case BALANCE:
				Balance balance = (Balance) obj;
				TBalance tBalance = new TBalance();
				deepCopy(balance, tBalance);
				serializer = new TSerializer(new TBinaryProtocol.Factory());
				try
				{
					serialBytes = serializer.serialize(tBalance);
				} catch (TException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
					serialBytes = null;
				}
				break;
		}

		return serialBytes;
	}

	// TODO Auto-generated catch block,
	// deSerialType = 1: TAdManagerContext;
	// deSerialType = 2: TDspContext;
	// deSerialType = 3: TBalance;
	public Object deSerializefromBytes(byte[] bytes, BinaryType deSerialType)
	{

		TDeserializer deserializer = new TDeserializer(new TBinaryProtocol.Factory());
		Object ret = null;

		if (deSerialType == BinaryType.ADMANAGER)
		{
			TAdManagerContext tAdManagerContext = new TAdManagerContext();
			try
			{
				deserializer.deserialize(tAdManagerContext, bytes);
			} catch (TException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			AdManagerContext adManagerContext = new AdManagerContext();
			deepCopy(tAdManagerContext, adManagerContext);
			ret = adManagerContext;
		}
		if (deSerialType == BinaryType.DSP)
		{
			TDspContext tDspContext = new TDspContext();
			try
			{
				deserializer.deserialize(tDspContext, bytes);
			} catch (TException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			DspContext dspContext = new DspContext();
			deepCopy(tDspContext, dspContext);
			ret = dspContext;
		}
		if (deSerialType == BinaryType.BALANCE)
		{
			TBalance tBalance = new TBalance();
			try
			{
				deserializer.deserialize(tBalance, bytes);
			} catch (TException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Balance balance = new Balance(0, new ArrayList<BalanceObj>());
			deepCopy(tBalance, balance);
			ret = balance;
		}

		return ret;
	}

	public void deepCopy(AdManagerContext adManagerContext, TAdManagerContext tAdManagerContext)
	{
		try
		{
			 
		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	public void deepCopy(DspContext dspContext, TDspContext tDspContext)
	{

		try
		{
			 
			if (dspContext == null)
			{
				return;
			}

			 

		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deepCopy(Balance balance, TBalance tBalance)
	{
		if (balance == null)
		{
			return;
		}
		try
		{
			tBalance.setVersion(balance.Version);
			List<TBalanceObj> mbObj = new ArrayList<TBalanceObj>();
			for (BalanceObj obj : balance.mbObj)
			{
				mbObj.add(new TBalanceObj(obj.Id, obj.ListName, obj.DataType, obj.NeedSyncBalance.toString(), obj.Status, obj.NewXBalance.toString(), obj.NewXHit.toString(), obj.NewXBudget
						.toString(), obj.NewTotalHit.toString(), obj.NewTotalBudget.toString(), obj.Version));
			}
			tBalance.setMbObj(mbObj);
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deepCopy(TAdManagerContext tAdManagerContext, AdManagerContext adManagerContext)
	{

		try
		{
			if (tAdManagerContext == null)
			{
				return;
			}

			adManagerContext.toTime = DateUtil.parseDate(tAdManagerContext.toTime, DATE_STRING_FORMAT);
 
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deepCopy(TDspContext tDspContext, DspContext dspContext)
	{
		if (tDspContext == null)
		{
			return;
		}

		dspContext.toTime = DateUtil.parseDate(tDspContext.toTime, DATE_STRING_FORMAT);

		try
		{
		 
			
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deepCopy(TBalance tBalance, Balance balance)
	{
		if (tBalance == null)
		{
			return;
		}
		try
		{
			balance.Version = tBalance.getVersion();
			List<BalanceObj> mbObj = new ArrayList<BalanceObj>();
			for (TBalanceObj obj : tBalance.mbObj)
			{
				mbObj.add(new BalanceObj(obj.id, obj.listName, obj.dataType, obj.needSyncBalance, obj.status, obj.newXBalance, obj.newXHit, obj.newXBudget, obj.newTotalHit, obj.newTotalBudget, obj.version));
			}
			balance.mbObj = mbObj;
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
