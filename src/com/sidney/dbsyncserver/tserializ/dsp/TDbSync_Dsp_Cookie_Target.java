/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.sidney.dbsyncserver.tserializ.dsp;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TDbSync_Dsp_Cookie_Target implements org.apache.thrift.TBase<TDbSync_Dsp_Cookie_Target, TDbSync_Dsp_Cookie_Target._Fields>, java.io.Serializable, Cloneable, Comparable<TDbSync_Dsp_Cookie_Target> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TDbSync_Dsp_Cookie_Target");

  private static final org.apache.thrift.protocol.TField AD_SPACE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("adSpaceId", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField CAMPAIGN_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("campaignId", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField PRICE_FIELD_DESC = new org.apache.thrift.protocol.TField("price", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("Status", org.apache.thrift.protocol.TType.I32, (short)4);
  private static final org.apache.thrift.protocol.TField LAST_CHANGED_FIELD_DESC = new org.apache.thrift.protocol.TField("lastChanged", org.apache.thrift.protocol.TType.STRING, (short)5);
  private static final org.apache.thrift.protocol.TField MLT_VISITOR_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("mltVisitorId", org.apache.thrift.protocol.TType.STRING, (short)6);
  private static final org.apache.thrift.protocol.TField IP_FIELD_DESC = new org.apache.thrift.protocol.TField("ip", org.apache.thrift.protocol.TType.STRING, (short)7);
  private static final org.apache.thrift.protocol.TField TARGET_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("target_type", org.apache.thrift.protocol.TType.I32, (short)8);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TDbSync_Dsp_Cookie_TargetStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TDbSync_Dsp_Cookie_TargetTupleSchemeFactory());
  }

  public int adSpaceId; // required
  public int campaignId; // required
  public String price; // required
  public int Status; // required
  public String lastChanged; // required
  public String mltVisitorId; // required
  public String ip; // required
  public int target_type; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    AD_SPACE_ID((short)1, "adSpaceId"),
    CAMPAIGN_ID((short)2, "campaignId"),
    PRICE((short)3, "price"),
    STATUS((short)4, "Status"),
    LAST_CHANGED((short)5, "lastChanged"),
    MLT_VISITOR_ID((short)6, "mltVisitorId"),
    IP((short)7, "ip"),
    TARGET_TYPE((short)8, "target_type");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // AD_SPACE_ID
          return AD_SPACE_ID;
        case 2: // CAMPAIGN_ID
          return CAMPAIGN_ID;
        case 3: // PRICE
          return PRICE;
        case 4: // STATUS
          return STATUS;
        case 5: // LAST_CHANGED
          return LAST_CHANGED;
        case 6: // MLT_VISITOR_ID
          return MLT_VISITOR_ID;
        case 7: // IP
          return IP;
        case 8: // TARGET_TYPE
          return TARGET_TYPE;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __ADSPACEID_ISSET_ID = 0;
  private static final int __CAMPAIGNID_ISSET_ID = 1;
  private static final int __STATUS_ISSET_ID = 2;
  private static final int __TARGET_TYPE_ISSET_ID = 3;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.AD_SPACE_ID, new org.apache.thrift.meta_data.FieldMetaData("adSpaceId", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.CAMPAIGN_ID, new org.apache.thrift.meta_data.FieldMetaData("campaignId", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.PRICE, new org.apache.thrift.meta_data.FieldMetaData("price", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.STATUS, new org.apache.thrift.meta_data.FieldMetaData("Status", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.LAST_CHANGED, new org.apache.thrift.meta_data.FieldMetaData("lastChanged", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.MLT_VISITOR_ID, new org.apache.thrift.meta_data.FieldMetaData("mltVisitorId", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.IP, new org.apache.thrift.meta_data.FieldMetaData("ip", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TARGET_TYPE, new org.apache.thrift.meta_data.FieldMetaData("target_type", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TDbSync_Dsp_Cookie_Target.class, metaDataMap);
  }

  public TDbSync_Dsp_Cookie_Target() {
  }

  public TDbSync_Dsp_Cookie_Target(
    int adSpaceId,
    int campaignId,
    String price,
    int Status,
    String lastChanged,
    String mltVisitorId,
    String ip,
    int target_type)
  {
    this();
    this.adSpaceId = adSpaceId;
    setAdSpaceIdIsSet(true);
    this.campaignId = campaignId;
    setCampaignIdIsSet(true);
    this.price = price;
    this.Status = Status;
    setStatusIsSet(true);
    this.lastChanged = lastChanged;
    this.mltVisitorId = mltVisitorId;
    this.ip = ip;
    this.target_type = target_type;
    setTarget_typeIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TDbSync_Dsp_Cookie_Target(TDbSync_Dsp_Cookie_Target other) {
    __isset_bitfield = other.__isset_bitfield;
    this.adSpaceId = other.adSpaceId;
    this.campaignId = other.campaignId;
    if (other.isSetPrice()) {
      this.price = other.price;
    }
    this.Status = other.Status;
    if (other.isSetLastChanged()) {
      this.lastChanged = other.lastChanged;
    }
    if (other.isSetMltVisitorId()) {
      this.mltVisitorId = other.mltVisitorId;
    }
    if (other.isSetIp()) {
      this.ip = other.ip;
    }
    this.target_type = other.target_type;
  }

  public TDbSync_Dsp_Cookie_Target deepCopy() {
    return new TDbSync_Dsp_Cookie_Target(this);
  }

  @Override
  public void clear() {
    setAdSpaceIdIsSet(false);
    this.adSpaceId = 0;
    setCampaignIdIsSet(false);
    this.campaignId = 0;
    this.price = null;
    setStatusIsSet(false);
    this.Status = 0;
    this.lastChanged = null;
    this.mltVisitorId = null;
    this.ip = null;
    setTarget_typeIsSet(false);
    this.target_type = 0;
  }

  public int getAdSpaceId() {
    return this.adSpaceId;
  }

  public TDbSync_Dsp_Cookie_Target setAdSpaceId(int adSpaceId) {
    this.adSpaceId = adSpaceId;
    setAdSpaceIdIsSet(true);
    return this;
  }

  public void unsetAdSpaceId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ADSPACEID_ISSET_ID);
  }

  /** Returns true if field adSpaceId is set (has been assigned a value) and false otherwise */
  public boolean isSetAdSpaceId() {
    return EncodingUtils.testBit(__isset_bitfield, __ADSPACEID_ISSET_ID);
  }

  public void setAdSpaceIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ADSPACEID_ISSET_ID, value);
  }

  public int getCampaignId() {
    return this.campaignId;
  }

  public TDbSync_Dsp_Cookie_Target setCampaignId(int campaignId) {
    this.campaignId = campaignId;
    setCampaignIdIsSet(true);
    return this;
  }

  public void unsetCampaignId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __CAMPAIGNID_ISSET_ID);
  }

  /** Returns true if field campaignId is set (has been assigned a value) and false otherwise */
  public boolean isSetCampaignId() {
    return EncodingUtils.testBit(__isset_bitfield, __CAMPAIGNID_ISSET_ID);
  }

  public void setCampaignIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __CAMPAIGNID_ISSET_ID, value);
  }

  public String getPrice() {
    return this.price;
  }

  public TDbSync_Dsp_Cookie_Target setPrice(String price) {
    this.price = price;
    return this;
  }

  public void unsetPrice() {
    this.price = null;
  }

  /** Returns true if field price is set (has been assigned a value) and false otherwise */
  public boolean isSetPrice() {
    return this.price != null;
  }

  public void setPriceIsSet(boolean value) {
    if (!value) {
      this.price = null;
    }
  }

  public int getStatus() {
    return this.Status;
  }

  public TDbSync_Dsp_Cookie_Target setStatus(int Status) {
    this.Status = Status;
    setStatusIsSet(true);
    return this;
  }

  public void unsetStatus() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __STATUS_ISSET_ID);
  }

  /** Returns true if field Status is set (has been assigned a value) and false otherwise */
  public boolean isSetStatus() {
    return EncodingUtils.testBit(__isset_bitfield, __STATUS_ISSET_ID);
  }

  public void setStatusIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __STATUS_ISSET_ID, value);
  }

  public String getLastChanged() {
    return this.lastChanged;
  }

  public TDbSync_Dsp_Cookie_Target setLastChanged(String lastChanged) {
    this.lastChanged = lastChanged;
    return this;
  }

  public void unsetLastChanged() {
    this.lastChanged = null;
  }

  /** Returns true if field lastChanged is set (has been assigned a value) and false otherwise */
  public boolean isSetLastChanged() {
    return this.lastChanged != null;
  }

  public void setLastChangedIsSet(boolean value) {
    if (!value) {
      this.lastChanged = null;
    }
  }

  public String getMltVisitorId() {
    return this.mltVisitorId;
  }

  public TDbSync_Dsp_Cookie_Target setMltVisitorId(String mltVisitorId) {
    this.mltVisitorId = mltVisitorId;
    return this;
  }

  public void unsetMltVisitorId() {
    this.mltVisitorId = null;
  }

  /** Returns true if field mltVisitorId is set (has been assigned a value) and false otherwise */
  public boolean isSetMltVisitorId() {
    return this.mltVisitorId != null;
  }

  public void setMltVisitorIdIsSet(boolean value) {
    if (!value) {
      this.mltVisitorId = null;
    }
  }

  public String getIp() {
    return this.ip;
  }

  public TDbSync_Dsp_Cookie_Target setIp(String ip) {
    this.ip = ip;
    return this;
  }

  public void unsetIp() {
    this.ip = null;
  }

  /** Returns true if field ip is set (has been assigned a value) and false otherwise */
  public boolean isSetIp() {
    return this.ip != null;
  }

  public void setIpIsSet(boolean value) {
    if (!value) {
      this.ip = null;
    }
  }

  public int getTarget_type() {
    return this.target_type;
  }

  public TDbSync_Dsp_Cookie_Target setTarget_type(int target_type) {
    this.target_type = target_type;
    setTarget_typeIsSet(true);
    return this;
  }

  public void unsetTarget_type() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __TARGET_TYPE_ISSET_ID);
  }

  /** Returns true if field target_type is set (has been assigned a value) and false otherwise */
  public boolean isSetTarget_type() {
    return EncodingUtils.testBit(__isset_bitfield, __TARGET_TYPE_ISSET_ID);
  }

  public void setTarget_typeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __TARGET_TYPE_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case AD_SPACE_ID:
      if (value == null) {
        unsetAdSpaceId();
      } else {
        setAdSpaceId((Integer)value);
      }
      break;

    case CAMPAIGN_ID:
      if (value == null) {
        unsetCampaignId();
      } else {
        setCampaignId((Integer)value);
      }
      break;

    case PRICE:
      if (value == null) {
        unsetPrice();
      } else {
        setPrice((String)value);
      }
      break;

    case STATUS:
      if (value == null) {
        unsetStatus();
      } else {
        setStatus((Integer)value);
      }
      break;

    case LAST_CHANGED:
      if (value == null) {
        unsetLastChanged();
      } else {
        setLastChanged((String)value);
      }
      break;

    case MLT_VISITOR_ID:
      if (value == null) {
        unsetMltVisitorId();
      } else {
        setMltVisitorId((String)value);
      }
      break;

    case IP:
      if (value == null) {
        unsetIp();
      } else {
        setIp((String)value);
      }
      break;

    case TARGET_TYPE:
      if (value == null) {
        unsetTarget_type();
      } else {
        setTarget_type((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case AD_SPACE_ID:
      return Integer.valueOf(getAdSpaceId());

    case CAMPAIGN_ID:
      return Integer.valueOf(getCampaignId());

    case PRICE:
      return getPrice();

    case STATUS:
      return Integer.valueOf(getStatus());

    case LAST_CHANGED:
      return getLastChanged();

    case MLT_VISITOR_ID:
      return getMltVisitorId();

    case IP:
      return getIp();

    case TARGET_TYPE:
      return Integer.valueOf(getTarget_type());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case AD_SPACE_ID:
      return isSetAdSpaceId();
    case CAMPAIGN_ID:
      return isSetCampaignId();
    case PRICE:
      return isSetPrice();
    case STATUS:
      return isSetStatus();
    case LAST_CHANGED:
      return isSetLastChanged();
    case MLT_VISITOR_ID:
      return isSetMltVisitorId();
    case IP:
      return isSetIp();
    case TARGET_TYPE:
      return isSetTarget_type();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TDbSync_Dsp_Cookie_Target)
      return this.equals((TDbSync_Dsp_Cookie_Target)that);
    return false;
  }

  public boolean equals(TDbSync_Dsp_Cookie_Target that) {
    if (that == null)
      return false;

    boolean this_present_adSpaceId = true;
    boolean that_present_adSpaceId = true;
    if (this_present_adSpaceId || that_present_adSpaceId) {
      if (!(this_present_adSpaceId && that_present_adSpaceId))
        return false;
      if (this.adSpaceId != that.adSpaceId)
        return false;
    }

    boolean this_present_campaignId = true;
    boolean that_present_campaignId = true;
    if (this_present_campaignId || that_present_campaignId) {
      if (!(this_present_campaignId && that_present_campaignId))
        return false;
      if (this.campaignId != that.campaignId)
        return false;
    }

    boolean this_present_price = true && this.isSetPrice();
    boolean that_present_price = true && that.isSetPrice();
    if (this_present_price || that_present_price) {
      if (!(this_present_price && that_present_price))
        return false;
      if (!this.price.equals(that.price))
        return false;
    }

    boolean this_present_Status = true;
    boolean that_present_Status = true;
    if (this_present_Status || that_present_Status) {
      if (!(this_present_Status && that_present_Status))
        return false;
      if (this.Status != that.Status)
        return false;
    }

    boolean this_present_lastChanged = true && this.isSetLastChanged();
    boolean that_present_lastChanged = true && that.isSetLastChanged();
    if (this_present_lastChanged || that_present_lastChanged) {
      if (!(this_present_lastChanged && that_present_lastChanged))
        return false;
      if (!this.lastChanged.equals(that.lastChanged))
        return false;
    }

    boolean this_present_mltVisitorId = true && this.isSetMltVisitorId();
    boolean that_present_mltVisitorId = true && that.isSetMltVisitorId();
    if (this_present_mltVisitorId || that_present_mltVisitorId) {
      if (!(this_present_mltVisitorId && that_present_mltVisitorId))
        return false;
      if (!this.mltVisitorId.equals(that.mltVisitorId))
        return false;
    }

    boolean this_present_ip = true && this.isSetIp();
    boolean that_present_ip = true && that.isSetIp();
    if (this_present_ip || that_present_ip) {
      if (!(this_present_ip && that_present_ip))
        return false;
      if (!this.ip.equals(that.ip))
        return false;
    }

    boolean this_present_target_type = true;
    boolean that_present_target_type = true;
    if (this_present_target_type || that_present_target_type) {
      if (!(this_present_target_type && that_present_target_type))
        return false;
      if (this.target_type != that.target_type)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(TDbSync_Dsp_Cookie_Target other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetAdSpaceId()).compareTo(other.isSetAdSpaceId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAdSpaceId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.adSpaceId, other.adSpaceId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCampaignId()).compareTo(other.isSetCampaignId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCampaignId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.campaignId, other.campaignId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPrice()).compareTo(other.isSetPrice());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPrice()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.price, other.price);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetStatus()).compareTo(other.isSetStatus());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStatus()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.Status, other.Status);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLastChanged()).compareTo(other.isSetLastChanged());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLastChanged()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.lastChanged, other.lastChanged);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMltVisitorId()).compareTo(other.isSetMltVisitorId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMltVisitorId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.mltVisitorId, other.mltVisitorId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetIp()).compareTo(other.isSetIp());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIp()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.ip, other.ip);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTarget_type()).compareTo(other.isSetTarget_type());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTarget_type()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.target_type, other.target_type);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("TDbSync_Dsp_Cookie_Target(");
    boolean first = true;

    sb.append("adSpaceId:");
    sb.append(this.adSpaceId);
    first = false;
    if (!first) sb.append(", ");
    sb.append("campaignId:");
    sb.append(this.campaignId);
    first = false;
    if (!first) sb.append(", ");
    sb.append("price:");
    if (this.price == null) {
      sb.append("null");
    } else {
      sb.append(this.price);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("Status:");
    sb.append(this.Status);
    first = false;
    if (!first) sb.append(", ");
    sb.append("lastChanged:");
    if (this.lastChanged == null) {
      sb.append("null");
    } else {
      sb.append(this.lastChanged);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("mltVisitorId:");
    if (this.mltVisitorId == null) {
      sb.append("null");
    } else {
      sb.append(this.mltVisitorId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("ip:");
    if (this.ip == null) {
      sb.append("null");
    } else {
      sb.append(this.ip);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("target_type:");
    sb.append(this.target_type);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'adSpaceId' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'campaignId' because it's a primitive and you chose the non-beans generator.
    if (price == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'price' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'Status' because it's a primitive and you chose the non-beans generator.
    if (lastChanged == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'lastChanged' was not present! Struct: " + toString());
    }
    if (mltVisitorId == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'mltVisitorId' was not present! Struct: " + toString());
    }
    if (ip == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'ip' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'target_type' because it's a primitive and you chose the non-beans generator.
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TDbSync_Dsp_Cookie_TargetStandardSchemeFactory implements SchemeFactory {
    public TDbSync_Dsp_Cookie_TargetStandardScheme getScheme() {
      return new TDbSync_Dsp_Cookie_TargetStandardScheme();
    }
  }

  private static class TDbSync_Dsp_Cookie_TargetStandardScheme extends StandardScheme<TDbSync_Dsp_Cookie_Target> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TDbSync_Dsp_Cookie_Target struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // AD_SPACE_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.adSpaceId = iprot.readI32();
              struct.setAdSpaceIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // CAMPAIGN_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.campaignId = iprot.readI32();
              struct.setCampaignIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // PRICE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.price = iprot.readString();
              struct.setPriceIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // STATUS
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.Status = iprot.readI32();
              struct.setStatusIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // LAST_CHANGED
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.lastChanged = iprot.readString();
              struct.setLastChangedIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // MLT_VISITOR_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.mltVisitorId = iprot.readString();
              struct.setMltVisitorIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // IP
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.ip = iprot.readString();
              struct.setIpIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 8: // TARGET_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.target_type = iprot.readI32();
              struct.setTarget_typeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      if (!struct.isSetAdSpaceId()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'adSpaceId' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetCampaignId()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'campaignId' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetStatus()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'Status' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetTarget_type()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'target_type' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, TDbSync_Dsp_Cookie_Target struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(AD_SPACE_ID_FIELD_DESC);
      oprot.writeI32(struct.adSpaceId);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(CAMPAIGN_ID_FIELD_DESC);
      oprot.writeI32(struct.campaignId);
      oprot.writeFieldEnd();
      if (struct.price != null) {
        oprot.writeFieldBegin(PRICE_FIELD_DESC);
        oprot.writeString(struct.price);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(STATUS_FIELD_DESC);
      oprot.writeI32(struct.Status);
      oprot.writeFieldEnd();
      if (struct.lastChanged != null) {
        oprot.writeFieldBegin(LAST_CHANGED_FIELD_DESC);
        oprot.writeString(struct.lastChanged);
        oprot.writeFieldEnd();
      }
      if (struct.mltVisitorId != null) {
        oprot.writeFieldBegin(MLT_VISITOR_ID_FIELD_DESC);
        oprot.writeString(struct.mltVisitorId);
        oprot.writeFieldEnd();
      }
      if (struct.ip != null) {
        oprot.writeFieldBegin(IP_FIELD_DESC);
        oprot.writeString(struct.ip);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(TARGET_TYPE_FIELD_DESC);
      oprot.writeI32(struct.target_type);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TDbSync_Dsp_Cookie_TargetTupleSchemeFactory implements SchemeFactory {
    public TDbSync_Dsp_Cookie_TargetTupleScheme getScheme() {
      return new TDbSync_Dsp_Cookie_TargetTupleScheme();
    }
  }

  private static class TDbSync_Dsp_Cookie_TargetTupleScheme extends TupleScheme<TDbSync_Dsp_Cookie_Target> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TDbSync_Dsp_Cookie_Target struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.adSpaceId);
      oprot.writeI32(struct.campaignId);
      oprot.writeString(struct.price);
      oprot.writeI32(struct.Status);
      oprot.writeString(struct.lastChanged);
      oprot.writeString(struct.mltVisitorId);
      oprot.writeString(struct.ip);
      oprot.writeI32(struct.target_type);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TDbSync_Dsp_Cookie_Target struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.adSpaceId = iprot.readI32();
      struct.setAdSpaceIdIsSet(true);
      struct.campaignId = iprot.readI32();
      struct.setCampaignIdIsSet(true);
      struct.price = iprot.readString();
      struct.setPriceIsSet(true);
      struct.Status = iprot.readI32();
      struct.setStatusIsSet(true);
      struct.lastChanged = iprot.readString();
      struct.setLastChangedIsSet(true);
      struct.mltVisitorId = iprot.readString();
      struct.setMltVisitorIdIsSet(true);
      struct.ip = iprot.readString();
      struct.setIpIsSet(true);
      struct.target_type = iprot.readI32();
      struct.setTarget_typeIsSet(true);
    }
  }

}
