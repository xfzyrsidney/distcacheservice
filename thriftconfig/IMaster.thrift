 namespace java com.adchina.dbsyncserver.syncinterface 
 
 struct ClientInfo
{
    1: required i64 version,
    2: optional string username,
    3: optional string password,
    4: optional string ip,
    5: optional string port,
    6: optional string time
}

 enum BinaryType {
  ADMANAGER = 1,
  DSP = 2,
  BALANCE = 3,
}

 struct BinaryData
{
    1: required i64    		version,
    2: required BinaryType	type,
    3: optional i64    		length,
    4: optional string 		checkalgorithm,
    5: optional binary 		checkcodes,
    6: required binary 		data 
}

 struct TransferInfo
{
    1: required i64        version,
    2: required i64        type,
    3: required i64        status,
    4: optional ClientInfo clientinfo,
    5: optional BinaryData data
}

 service IMaster{
  bool ping(),
  TransferInfo load(1:string fromTime, 2:string toTime, 3:i32 dbType),
  TransferInfo unLoad(1:string fromTime, 2:string toTime, 3:i32 dbType),
  string getDbTime(1:i32 dbType),
  TransferInfo syncBalance(1:TransferInfo info, 2:i32 dbType)
 }