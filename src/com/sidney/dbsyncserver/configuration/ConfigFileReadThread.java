package com.sidney.dbsyncserver.configuration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.adchina.common.MainLoopThread;
import com.adchina.configuration.ConfigurationManager;
import com.adchina.utils.StringUtil;
import com.sidney.dbsyncserver.init.GlobalInit;

public class ConfigFileReadThread extends MainLoopThread
{
	private static Log log = LogFactory.getLog(ConfigFileReadThread.class);
	private Date LastWriteTime;
	private static List<Integer> listTrackId;
	private static List<Integer> listTrackListName;
	private static List<Integer> listTrackDataType;

	public ConfigFileReadThread(int sleepTimeForDataRead, List<Integer> parm1, List<Integer> parm2, List<Integer> parm3)
	{
		super(sleepTimeForDataRead);
		listTrackId = parm1;
		listTrackListName = parm2;
		listTrackDataType = parm3;
		init();
	}

	public ConfigFileReadThread(List<Integer> parm1, List<Integer> parm2, List<Integer> parm3)
	{
		super();
		listTrackId = parm1;
		listTrackListName = parm2;
		listTrackDataType = parm3;
		init();
	}

	private void init()
	{
		Calendar cal = Calendar.getInstance();
		cal.set(1900, 1, 1);
		LastWriteTime = cal.getTime();
	}

	@Override
	public void mainLoop()
	{
		try
		{
			String filepath = ConfigurationManager.getAppSetting("ConfigFile");
			File fileinfo = null;
			if (!StringUtil.isNullOrEmpty(filepath))
			{
				fileinfo = new File(filepath);
			}
			if (StringUtil.isNullOrEmpty(filepath) || !fileinfo.exists())
			{
				filepath = GlobalInit.DYNAMIC_CONFIG_INI_PATH;
				fileinfo = new File(filepath);
				if (StringUtil.isNullOrEmpty(filepath) && !fileinfo.exists())
				{
					return;
				}
			}

			if (!LastWriteTime.before(new Date(fileinfo.lastModified())))
			{
				return;
			} else
			{
				LastWriteTime = new Date(fileinfo.lastModified());
				log.info(String.format("[ConfigurationHelper]:config.ini:%s,%s", filepath, LastWriteTime));
			}

			BufferedReader br = new BufferedReader(new FileReader(fileinfo));
			String line = null;
			while (((line = br.readLine()) != null))
			{
				String[] param = line.split("=");

				if (null != param && !StringUtil.isNullOrEmpty(param[0]))
				{

					if (param[0].equals("TrackId"))
					{
						listTrackId.clear();
						if (param.length >= 2 && !StringUtil.isNullOrEmpty(param[1]))
						{
							String[] Tracks = param[1].split(",");
							for (String v : Tracks)
							{
								try
								{
									int outResult = Integer.parseInt(v);
									listTrackId.add(outResult);
								} catch (NumberFormatException e)
								{
									// TODO Auto-generated catch
									// block
									e.printStackTrace();
								}
							}

						}
					}

					if (param[0].equals("TrackListName"))
					{
						listTrackListName.clear();
						if (param.length >= 2 && !StringUtil.isNullOrEmpty(param[1]))
						{
							String[] Tracks = param[1].split(",");
							for (String v : Tracks)
							{
								try
								{
									int outResult = Integer.parseInt(v);
									listTrackListName.add(outResult);
								} catch (NumberFormatException e)
								{
									// TODO Auto-generated catch
									// block
									e.printStackTrace();
								}
							}

						}
					}

					if (param[0].equals("TrackDataType"))
					{
						listTrackDataType.clear();
						if (param.length >= 2 && !StringUtil.isNullOrEmpty(param[1]))
						{
							String[] Tracks = param[1].split(",");
							for (String v : Tracks)
							{
								try
								{
									int outResult = Integer.parseInt(v);
									listTrackDataType.add(outResult);
								} catch (NumberFormatException e)
								{
									// TODO Auto-generated catch
									// block
									e.printStackTrace();
								}
							}

						}
					}

				}
			}
			br.close();
		} catch (Exception ex)
		{
			log.error(ex);
		}
	}
}
