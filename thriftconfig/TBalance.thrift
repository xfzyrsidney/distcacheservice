 namespace java com.adchina.dbsyncserver.tserializ.balance 
 
struct TBalanceObj {
  1: required i32 id,
  2: required i32 listName,
  3: required i32 dataType,
  4: required string needSyncBalance,
  5: required i32 status,
  6: required string newXBalance,
  7: required string newXHit,
  8: required string newXBudget,
  9: required string newTotalHit,
  10: required string newTotalBudget,
  11: required i64 version
}


struct TBalance {
  1: optional i32 version,
  2: required list<TBalanceObj> mbObj
}
