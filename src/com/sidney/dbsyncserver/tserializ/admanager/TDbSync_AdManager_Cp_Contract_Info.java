/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.sidney.dbsyncserver.tserializ.admanager;

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

public class TDbSync_AdManager_Cp_Contract_Info implements org.apache.thrift.TBase<TDbSync_AdManager_Cp_Contract_Info, TDbSync_AdManager_Cp_Contract_Info._Fields>, java.io.Serializable, Cloneable, Comparable<TDbSync_AdManager_Cp_Contract_Info> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TDbSync_AdManager_Cp_Contract_Info");

  private static final org.apache.thrift.protocol.TField INDUSTRY_FIELD_DESC = new org.apache.thrift.protocol.TField("industry", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField CAMPAIGN_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("campaignID", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("status", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField LAST_CHANGED_FIELD_DESC = new org.apache.thrift.protocol.TField("lastChanged", org.apache.thrift.protocol.TType.STRING, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TDbSync_AdManager_Cp_Contract_InfoStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TDbSync_AdManager_Cp_Contract_InfoTupleSchemeFactory());
  }

  public int industry; // required
  public String campaignID; // required
  public int status; // required
  public String lastChanged; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    INDUSTRY((short)1, "industry"),
    CAMPAIGN_ID((short)2, "campaignID"),
    STATUS((short)3, "status"),
    LAST_CHANGED((short)4, "lastChanged");

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
        case 1: // INDUSTRY
          return INDUSTRY;
        case 2: // CAMPAIGN_ID
          return CAMPAIGN_ID;
        case 3: // STATUS
          return STATUS;
        case 4: // LAST_CHANGED
          return LAST_CHANGED;
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
  private static final int __INDUSTRY_ISSET_ID = 0;
  private static final int __STATUS_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.INDUSTRY, new org.apache.thrift.meta_data.FieldMetaData("industry", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.CAMPAIGN_ID, new org.apache.thrift.meta_data.FieldMetaData("campaignID", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.STATUS, new org.apache.thrift.meta_data.FieldMetaData("status", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.LAST_CHANGED, new org.apache.thrift.meta_data.FieldMetaData("lastChanged", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TDbSync_AdManager_Cp_Contract_Info.class, metaDataMap);
  }

  public TDbSync_AdManager_Cp_Contract_Info() {
  }

  public TDbSync_AdManager_Cp_Contract_Info(
    int industry,
    String campaignID,
    int status,
    String lastChanged)
  {
    this();
    this.industry = industry;
    setIndustryIsSet(true);
    this.campaignID = campaignID;
    this.status = status;
    setStatusIsSet(true);
    this.lastChanged = lastChanged;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TDbSync_AdManager_Cp_Contract_Info(TDbSync_AdManager_Cp_Contract_Info other) {
    __isset_bitfield = other.__isset_bitfield;
    this.industry = other.industry;
    if (other.isSetCampaignID()) {
      this.campaignID = other.campaignID;
    }
    this.status = other.status;
    if (other.isSetLastChanged()) {
      this.lastChanged = other.lastChanged;
    }
  }

  public TDbSync_AdManager_Cp_Contract_Info deepCopy() {
    return new TDbSync_AdManager_Cp_Contract_Info(this);
  }

  @Override
  public void clear() {
    setIndustryIsSet(false);
    this.industry = 0;
    this.campaignID = null;
    setStatusIsSet(false);
    this.status = 0;
    this.lastChanged = null;
  }

  public int getIndustry() {
    return this.industry;
  }

  public TDbSync_AdManager_Cp_Contract_Info setIndustry(int industry) {
    this.industry = industry;
    setIndustryIsSet(true);
    return this;
  }

  public void unsetIndustry() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __INDUSTRY_ISSET_ID);
  }

  /** Returns true if field industry is set (has been assigned a value) and false otherwise */
  public boolean isSetIndustry() {
    return EncodingUtils.testBit(__isset_bitfield, __INDUSTRY_ISSET_ID);
  }

  public void setIndustryIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __INDUSTRY_ISSET_ID, value);
  }

  public String getCampaignID() {
    return this.campaignID;
  }

  public TDbSync_AdManager_Cp_Contract_Info setCampaignID(String campaignID) {
    this.campaignID = campaignID;
    return this;
  }

  public void unsetCampaignID() {
    this.campaignID = null;
  }

  /** Returns true if field campaignID is set (has been assigned a value) and false otherwise */
  public boolean isSetCampaignID() {
    return this.campaignID != null;
  }

  public void setCampaignIDIsSet(boolean value) {
    if (!value) {
      this.campaignID = null;
    }
  }

  public int getStatus() {
    return this.status;
  }

  public TDbSync_AdManager_Cp_Contract_Info setStatus(int status) {
    this.status = status;
    setStatusIsSet(true);
    return this;
  }

  public void unsetStatus() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __STATUS_ISSET_ID);
  }

  /** Returns true if field status is set (has been assigned a value) and false otherwise */
  public boolean isSetStatus() {
    return EncodingUtils.testBit(__isset_bitfield, __STATUS_ISSET_ID);
  }

  public void setStatusIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __STATUS_ISSET_ID, value);
  }

  public String getLastChanged() {
    return this.lastChanged;
  }

  public TDbSync_AdManager_Cp_Contract_Info setLastChanged(String lastChanged) {
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

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case INDUSTRY:
      if (value == null) {
        unsetIndustry();
      } else {
        setIndustry((Integer)value);
      }
      break;

    case CAMPAIGN_ID:
      if (value == null) {
        unsetCampaignID();
      } else {
        setCampaignID((String)value);
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

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case INDUSTRY:
      return Integer.valueOf(getIndustry());

    case CAMPAIGN_ID:
      return getCampaignID();

    case STATUS:
      return Integer.valueOf(getStatus());

    case LAST_CHANGED:
      return getLastChanged();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case INDUSTRY:
      return isSetIndustry();
    case CAMPAIGN_ID:
      return isSetCampaignID();
    case STATUS:
      return isSetStatus();
    case LAST_CHANGED:
      return isSetLastChanged();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TDbSync_AdManager_Cp_Contract_Info)
      return this.equals((TDbSync_AdManager_Cp_Contract_Info)that);
    return false;
  }

  public boolean equals(TDbSync_AdManager_Cp_Contract_Info that) {
    if (that == null)
      return false;

    boolean this_present_industry = true;
    boolean that_present_industry = true;
    if (this_present_industry || that_present_industry) {
      if (!(this_present_industry && that_present_industry))
        return false;
      if (this.industry != that.industry)
        return false;
    }

    boolean this_present_campaignID = true && this.isSetCampaignID();
    boolean that_present_campaignID = true && that.isSetCampaignID();
    if (this_present_campaignID || that_present_campaignID) {
      if (!(this_present_campaignID && that_present_campaignID))
        return false;
      if (!this.campaignID.equals(that.campaignID))
        return false;
    }

    boolean this_present_status = true;
    boolean that_present_status = true;
    if (this_present_status || that_present_status) {
      if (!(this_present_status && that_present_status))
        return false;
      if (this.status != that.status)
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

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(TDbSync_AdManager_Cp_Contract_Info other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetIndustry()).compareTo(other.isSetIndustry());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIndustry()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.industry, other.industry);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCampaignID()).compareTo(other.isSetCampaignID());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCampaignID()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.campaignID, other.campaignID);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetStatus()).compareTo(other.isSetStatus());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStatus()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.status, other.status);
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
    StringBuilder sb = new StringBuilder("TDbSync_AdManager_Cp_Contract_Info(");
    boolean first = true;

    sb.append("industry:");
    sb.append(this.industry);
    first = false;
    if (!first) sb.append(", ");
    sb.append("campaignID:");
    if (this.campaignID == null) {
      sb.append("null");
    } else {
      sb.append(this.campaignID);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("status:");
    sb.append(this.status);
    first = false;
    if (!first) sb.append(", ");
    sb.append("lastChanged:");
    if (this.lastChanged == null) {
      sb.append("null");
    } else {
      sb.append(this.lastChanged);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'industry' because it's a primitive and you chose the non-beans generator.
    if (campaignID == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'campaignID' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'status' because it's a primitive and you chose the non-beans generator.
    if (lastChanged == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'lastChanged' was not present! Struct: " + toString());
    }
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

  private static class TDbSync_AdManager_Cp_Contract_InfoStandardSchemeFactory implements SchemeFactory {
    public TDbSync_AdManager_Cp_Contract_InfoStandardScheme getScheme() {
      return new TDbSync_AdManager_Cp_Contract_InfoStandardScheme();
    }
  }

  private static class TDbSync_AdManager_Cp_Contract_InfoStandardScheme extends StandardScheme<TDbSync_AdManager_Cp_Contract_Info> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TDbSync_AdManager_Cp_Contract_Info struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // INDUSTRY
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.industry = iprot.readI32();
              struct.setIndustryIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // CAMPAIGN_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.campaignID = iprot.readString();
              struct.setCampaignIDIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // STATUS
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.status = iprot.readI32();
              struct.setStatusIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // LAST_CHANGED
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.lastChanged = iprot.readString();
              struct.setLastChangedIsSet(true);
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
      if (!struct.isSetIndustry()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'industry' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetStatus()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'status' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, TDbSync_AdManager_Cp_Contract_Info struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(INDUSTRY_FIELD_DESC);
      oprot.writeI32(struct.industry);
      oprot.writeFieldEnd();
      if (struct.campaignID != null) {
        oprot.writeFieldBegin(CAMPAIGN_ID_FIELD_DESC);
        oprot.writeString(struct.campaignID);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(STATUS_FIELD_DESC);
      oprot.writeI32(struct.status);
      oprot.writeFieldEnd();
      if (struct.lastChanged != null) {
        oprot.writeFieldBegin(LAST_CHANGED_FIELD_DESC);
        oprot.writeString(struct.lastChanged);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TDbSync_AdManager_Cp_Contract_InfoTupleSchemeFactory implements SchemeFactory {
    public TDbSync_AdManager_Cp_Contract_InfoTupleScheme getScheme() {
      return new TDbSync_AdManager_Cp_Contract_InfoTupleScheme();
    }
  }

  private static class TDbSync_AdManager_Cp_Contract_InfoTupleScheme extends TupleScheme<TDbSync_AdManager_Cp_Contract_Info> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TDbSync_AdManager_Cp_Contract_Info struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.industry);
      oprot.writeString(struct.campaignID);
      oprot.writeI32(struct.status);
      oprot.writeString(struct.lastChanged);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TDbSync_AdManager_Cp_Contract_Info struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.industry = iprot.readI32();
      struct.setIndustryIsSet(true);
      struct.campaignID = iprot.readString();
      struct.setCampaignIDIsSet(true);
      struct.status = iprot.readI32();
      struct.setStatusIsSet(true);
      struct.lastChanged = iprot.readString();
      struct.setLastChangedIsSet(true);
    }
  }

}

