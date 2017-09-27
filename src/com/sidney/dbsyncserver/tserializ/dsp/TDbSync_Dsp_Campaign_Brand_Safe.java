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

public class TDbSync_Dsp_Campaign_Brand_Safe implements org.apache.thrift.TBase<TDbSync_Dsp_Campaign_Brand_Safe, TDbSync_Dsp_Campaign_Brand_Safe._Fields>, java.io.Serializable, Cloneable, Comparable<TDbSync_Dsp_Campaign_Brand_Safe> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TDbSync_Dsp_Campaign_Brand_Safe");

  private static final org.apache.thrift.protocol.TField CAMPAIGN_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("campaignID", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("status", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField LAST_CHANGED_FIELD_DESC = new org.apache.thrift.protocol.TField("lastChanged", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField BLACK_IDS_FIELD_DESC = new org.apache.thrift.protocol.TField("blackIDs", org.apache.thrift.protocol.TType.STRING, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TDbSync_Dsp_Campaign_Brand_SafeStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TDbSync_Dsp_Campaign_Brand_SafeTupleSchemeFactory());
  }

  public int campaignID; // required
  public int status; // required
  public String lastChanged; // required
  public String blackIDs; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    CAMPAIGN_ID((short)1, "campaignID"),
    STATUS((short)2, "status"),
    LAST_CHANGED((short)3, "lastChanged"),
    BLACK_IDS((short)4, "blackIDs");

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
        case 1: // CAMPAIGN_ID
          return CAMPAIGN_ID;
        case 2: // STATUS
          return STATUS;
        case 3: // LAST_CHANGED
          return LAST_CHANGED;
        case 4: // BLACK_IDS
          return BLACK_IDS;
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
  private static final int __CAMPAIGNID_ISSET_ID = 0;
  private static final int __STATUS_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.CAMPAIGN_ID, new org.apache.thrift.meta_data.FieldMetaData("campaignID", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.STATUS, new org.apache.thrift.meta_data.FieldMetaData("status", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.LAST_CHANGED, new org.apache.thrift.meta_data.FieldMetaData("lastChanged", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.BLACK_IDS, new org.apache.thrift.meta_data.FieldMetaData("blackIDs", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TDbSync_Dsp_Campaign_Brand_Safe.class, metaDataMap);
  }

  public TDbSync_Dsp_Campaign_Brand_Safe() {
  }

  public TDbSync_Dsp_Campaign_Brand_Safe(
    int campaignID,
    int status,
    String lastChanged,
    String blackIDs)
  {
    this();
    this.campaignID = campaignID;
    setCampaignIDIsSet(true);
    this.status = status;
    setStatusIsSet(true);
    this.lastChanged = lastChanged;
    this.blackIDs = blackIDs;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TDbSync_Dsp_Campaign_Brand_Safe(TDbSync_Dsp_Campaign_Brand_Safe other) {
    __isset_bitfield = other.__isset_bitfield;
    this.campaignID = other.campaignID;
    this.status = other.status;
    if (other.isSetLastChanged()) {
      this.lastChanged = other.lastChanged;
    }
    if (other.isSetBlackIDs()) {
      this.blackIDs = other.blackIDs;
    }
  }

  public TDbSync_Dsp_Campaign_Brand_Safe deepCopy() {
    return new TDbSync_Dsp_Campaign_Brand_Safe(this);
  }

  @Override
  public void clear() {
    setCampaignIDIsSet(false);
    this.campaignID = 0;
    setStatusIsSet(false);
    this.status = 0;
    this.lastChanged = null;
    this.blackIDs = null;
  }

  public int getCampaignID() {
    return this.campaignID;
  }

  public TDbSync_Dsp_Campaign_Brand_Safe setCampaignID(int campaignID) {
    this.campaignID = campaignID;
    setCampaignIDIsSet(true);
    return this;
  }

  public void unsetCampaignID() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __CAMPAIGNID_ISSET_ID);
  }

  /** Returns true if field campaignID is set (has been assigned a value) and false otherwise */
  public boolean isSetCampaignID() {
    return EncodingUtils.testBit(__isset_bitfield, __CAMPAIGNID_ISSET_ID);
  }

  public void setCampaignIDIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __CAMPAIGNID_ISSET_ID, value);
  }

  public int getStatus() {
    return this.status;
  }

  public TDbSync_Dsp_Campaign_Brand_Safe setStatus(int status) {
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

  public TDbSync_Dsp_Campaign_Brand_Safe setLastChanged(String lastChanged) {
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

  public String getBlackIDs() {
    return this.blackIDs;
  }

  public TDbSync_Dsp_Campaign_Brand_Safe setBlackIDs(String blackIDs) {
    this.blackIDs = blackIDs;
    return this;
  }

  public void unsetBlackIDs() {
    this.blackIDs = null;
  }

  /** Returns true if field blackIDs is set (has been assigned a value) and false otherwise */
  public boolean isSetBlackIDs() {
    return this.blackIDs != null;
  }

  public void setBlackIDsIsSet(boolean value) {
    if (!value) {
      this.blackIDs = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case CAMPAIGN_ID:
      if (value == null) {
        unsetCampaignID();
      } else {
        setCampaignID((Integer)value);
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

    case BLACK_IDS:
      if (value == null) {
        unsetBlackIDs();
      } else {
        setBlackIDs((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case CAMPAIGN_ID:
      return Integer.valueOf(getCampaignID());

    case STATUS:
      return Integer.valueOf(getStatus());

    case LAST_CHANGED:
      return getLastChanged();

    case BLACK_IDS:
      return getBlackIDs();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case CAMPAIGN_ID:
      return isSetCampaignID();
    case STATUS:
      return isSetStatus();
    case LAST_CHANGED:
      return isSetLastChanged();
    case BLACK_IDS:
      return isSetBlackIDs();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TDbSync_Dsp_Campaign_Brand_Safe)
      return this.equals((TDbSync_Dsp_Campaign_Brand_Safe)that);
    return false;
  }

  public boolean equals(TDbSync_Dsp_Campaign_Brand_Safe that) {
    if (that == null)
      return false;

    boolean this_present_campaignID = true;
    boolean that_present_campaignID = true;
    if (this_present_campaignID || that_present_campaignID) {
      if (!(this_present_campaignID && that_present_campaignID))
        return false;
      if (this.campaignID != that.campaignID)
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

    boolean this_present_blackIDs = true && this.isSetBlackIDs();
    boolean that_present_blackIDs = true && that.isSetBlackIDs();
    if (this_present_blackIDs || that_present_blackIDs) {
      if (!(this_present_blackIDs && that_present_blackIDs))
        return false;
      if (!this.blackIDs.equals(that.blackIDs))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(TDbSync_Dsp_Campaign_Brand_Safe other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

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
    lastComparison = Boolean.valueOf(isSetBlackIDs()).compareTo(other.isSetBlackIDs());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBlackIDs()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.blackIDs, other.blackIDs);
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
    StringBuilder sb = new StringBuilder("TDbSync_Dsp_Campaign_Brand_Safe(");
    boolean first = true;

    sb.append("campaignID:");
    sb.append(this.campaignID);
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
    if (!first) sb.append(", ");
    sb.append("blackIDs:");
    if (this.blackIDs == null) {
      sb.append("null");
    } else {
      sb.append(this.blackIDs);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'campaignID' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'status' because it's a primitive and you chose the non-beans generator.
    if (lastChanged == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'lastChanged' was not present! Struct: " + toString());
    }
    if (blackIDs == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'blackIDs' was not present! Struct: " + toString());
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

  private static class TDbSync_Dsp_Campaign_Brand_SafeStandardSchemeFactory implements SchemeFactory {
    public TDbSync_Dsp_Campaign_Brand_SafeStandardScheme getScheme() {
      return new TDbSync_Dsp_Campaign_Brand_SafeStandardScheme();
    }
  }

  private static class TDbSync_Dsp_Campaign_Brand_SafeStandardScheme extends StandardScheme<TDbSync_Dsp_Campaign_Brand_Safe> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TDbSync_Dsp_Campaign_Brand_Safe struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // CAMPAIGN_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.campaignID = iprot.readI32();
              struct.setCampaignIDIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // STATUS
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.status = iprot.readI32();
              struct.setStatusIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // LAST_CHANGED
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.lastChanged = iprot.readString();
              struct.setLastChangedIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // BLACK_IDS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.blackIDs = iprot.readString();
              struct.setBlackIDsIsSet(true);
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
      if (!struct.isSetCampaignID()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'campaignID' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetStatus()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'status' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, TDbSync_Dsp_Campaign_Brand_Safe struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(CAMPAIGN_ID_FIELD_DESC);
      oprot.writeI32(struct.campaignID);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(STATUS_FIELD_DESC);
      oprot.writeI32(struct.status);
      oprot.writeFieldEnd();
      if (struct.lastChanged != null) {
        oprot.writeFieldBegin(LAST_CHANGED_FIELD_DESC);
        oprot.writeString(struct.lastChanged);
        oprot.writeFieldEnd();
      }
      if (struct.blackIDs != null) {
        oprot.writeFieldBegin(BLACK_IDS_FIELD_DESC);
        oprot.writeString(struct.blackIDs);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TDbSync_Dsp_Campaign_Brand_SafeTupleSchemeFactory implements SchemeFactory {
    public TDbSync_Dsp_Campaign_Brand_SafeTupleScheme getScheme() {
      return new TDbSync_Dsp_Campaign_Brand_SafeTupleScheme();
    }
  }

  private static class TDbSync_Dsp_Campaign_Brand_SafeTupleScheme extends TupleScheme<TDbSync_Dsp_Campaign_Brand_Safe> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TDbSync_Dsp_Campaign_Brand_Safe struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.campaignID);
      oprot.writeI32(struct.status);
      oprot.writeString(struct.lastChanged);
      oprot.writeString(struct.blackIDs);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TDbSync_Dsp_Campaign_Brand_Safe struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.campaignID = iprot.readI32();
      struct.setCampaignIDIsSet(true);
      struct.status = iprot.readI32();
      struct.setStatusIsSet(true);
      struct.lastChanged = iprot.readString();
      struct.setLastChangedIsSet(true);
      struct.blackIDs = iprot.readString();
      struct.setBlackIDsIsSet(true);
    }
  }

}
