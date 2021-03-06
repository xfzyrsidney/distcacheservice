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

public class TDbSync_AdManager_Media_Buy_Partial_Date implements org.apache.thrift.TBase<TDbSync_AdManager_Media_Buy_Partial_Date, TDbSync_AdManager_Media_Buy_Partial_Date._Fields>, java.io.Serializable, Cloneable, Comparable<TDbSync_AdManager_Media_Buy_Partial_Date> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TDbSync_AdManager_Media_Buy_Partial_Date");

  private static final org.apache.thrift.protocol.TField MEDIA_BUY_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("mediaBuyID", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField START_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("startTime", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("status", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField LAST_CHANGED_FIELD_DESC = new org.apache.thrift.protocol.TField("lastChanged", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField END_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("endTime", org.apache.thrift.protocol.TType.STRING, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TDbSync_AdManager_Media_Buy_Partial_DateStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TDbSync_AdManager_Media_Buy_Partial_DateTupleSchemeFactory());
  }

  public int mediaBuyID; // required
  public String startTime; // required
  public int status; // required
  public String lastChanged; // required
  public String endTime; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    MEDIA_BUY_ID((short)1, "mediaBuyID"),
    START_TIME((short)2, "startTime"),
    STATUS((short)3, "status"),
    LAST_CHANGED((short)4, "lastChanged"),
    END_TIME((short)5, "endTime");

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
        case 1: // MEDIA_BUY_ID
          return MEDIA_BUY_ID;
        case 2: // START_TIME
          return START_TIME;
        case 3: // STATUS
          return STATUS;
        case 4: // LAST_CHANGED
          return LAST_CHANGED;
        case 5: // END_TIME
          return END_TIME;
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
  private static final int __MEDIABUYID_ISSET_ID = 0;
  private static final int __STATUS_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.MEDIA_BUY_ID, new org.apache.thrift.meta_data.FieldMetaData("mediaBuyID", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.START_TIME, new org.apache.thrift.meta_data.FieldMetaData("startTime", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.STATUS, new org.apache.thrift.meta_data.FieldMetaData("status", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.LAST_CHANGED, new org.apache.thrift.meta_data.FieldMetaData("lastChanged", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.END_TIME, new org.apache.thrift.meta_data.FieldMetaData("endTime", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TDbSync_AdManager_Media_Buy_Partial_Date.class, metaDataMap);
  }

  public TDbSync_AdManager_Media_Buy_Partial_Date() {
  }

  public TDbSync_AdManager_Media_Buy_Partial_Date(
    int mediaBuyID,
    String startTime,
    int status,
    String lastChanged,
    String endTime)
  {
    this();
    this.mediaBuyID = mediaBuyID;
    setMediaBuyIDIsSet(true);
    this.startTime = startTime;
    this.status = status;
    setStatusIsSet(true);
    this.lastChanged = lastChanged;
    this.endTime = endTime;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TDbSync_AdManager_Media_Buy_Partial_Date(TDbSync_AdManager_Media_Buy_Partial_Date other) {
    __isset_bitfield = other.__isset_bitfield;
    this.mediaBuyID = other.mediaBuyID;
    if (other.isSetStartTime()) {
      this.startTime = other.startTime;
    }
    this.status = other.status;
    if (other.isSetLastChanged()) {
      this.lastChanged = other.lastChanged;
    }
    if (other.isSetEndTime()) {
      this.endTime = other.endTime;
    }
  }

  public TDbSync_AdManager_Media_Buy_Partial_Date deepCopy() {
    return new TDbSync_AdManager_Media_Buy_Partial_Date(this);
  }

  @Override
  public void clear() {
    setMediaBuyIDIsSet(false);
    this.mediaBuyID = 0;
    this.startTime = null;
    setStatusIsSet(false);
    this.status = 0;
    this.lastChanged = null;
    this.endTime = null;
  }

  public int getMediaBuyID() {
    return this.mediaBuyID;
  }

  public TDbSync_AdManager_Media_Buy_Partial_Date setMediaBuyID(int mediaBuyID) {
    this.mediaBuyID = mediaBuyID;
    setMediaBuyIDIsSet(true);
    return this;
  }

  public void unsetMediaBuyID() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __MEDIABUYID_ISSET_ID);
  }

  /** Returns true if field mediaBuyID is set (has been assigned a value) and false otherwise */
  public boolean isSetMediaBuyID() {
    return EncodingUtils.testBit(__isset_bitfield, __MEDIABUYID_ISSET_ID);
  }

  public void setMediaBuyIDIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __MEDIABUYID_ISSET_ID, value);
  }

  public String getStartTime() {
    return this.startTime;
  }

  public TDbSync_AdManager_Media_Buy_Partial_Date setStartTime(String startTime) {
    this.startTime = startTime;
    return this;
  }

  public void unsetStartTime() {
    this.startTime = null;
  }

  /** Returns true if field startTime is set (has been assigned a value) and false otherwise */
  public boolean isSetStartTime() {
    return this.startTime != null;
  }

  public void setStartTimeIsSet(boolean value) {
    if (!value) {
      this.startTime = null;
    }
  }

  public int getStatus() {
    return this.status;
  }

  public TDbSync_AdManager_Media_Buy_Partial_Date setStatus(int status) {
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

  public TDbSync_AdManager_Media_Buy_Partial_Date setLastChanged(String lastChanged) {
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

  public String getEndTime() {
    return this.endTime;
  }

  public TDbSync_AdManager_Media_Buy_Partial_Date setEndTime(String endTime) {
    this.endTime = endTime;
    return this;
  }

  public void unsetEndTime() {
    this.endTime = null;
  }

  /** Returns true if field endTime is set (has been assigned a value) and false otherwise */
  public boolean isSetEndTime() {
    return this.endTime != null;
  }

  public void setEndTimeIsSet(boolean value) {
    if (!value) {
      this.endTime = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case MEDIA_BUY_ID:
      if (value == null) {
        unsetMediaBuyID();
      } else {
        setMediaBuyID((Integer)value);
      }
      break;

    case START_TIME:
      if (value == null) {
        unsetStartTime();
      } else {
        setStartTime((String)value);
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

    case END_TIME:
      if (value == null) {
        unsetEndTime();
      } else {
        setEndTime((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case MEDIA_BUY_ID:
      return Integer.valueOf(getMediaBuyID());

    case START_TIME:
      return getStartTime();

    case STATUS:
      return Integer.valueOf(getStatus());

    case LAST_CHANGED:
      return getLastChanged();

    case END_TIME:
      return getEndTime();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case MEDIA_BUY_ID:
      return isSetMediaBuyID();
    case START_TIME:
      return isSetStartTime();
    case STATUS:
      return isSetStatus();
    case LAST_CHANGED:
      return isSetLastChanged();
    case END_TIME:
      return isSetEndTime();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TDbSync_AdManager_Media_Buy_Partial_Date)
      return this.equals((TDbSync_AdManager_Media_Buy_Partial_Date)that);
    return false;
  }

  public boolean equals(TDbSync_AdManager_Media_Buy_Partial_Date that) {
    if (that == null)
      return false;

    boolean this_present_mediaBuyID = true;
    boolean that_present_mediaBuyID = true;
    if (this_present_mediaBuyID || that_present_mediaBuyID) {
      if (!(this_present_mediaBuyID && that_present_mediaBuyID))
        return false;
      if (this.mediaBuyID != that.mediaBuyID)
        return false;
    }

    boolean this_present_startTime = true && this.isSetStartTime();
    boolean that_present_startTime = true && that.isSetStartTime();
    if (this_present_startTime || that_present_startTime) {
      if (!(this_present_startTime && that_present_startTime))
        return false;
      if (!this.startTime.equals(that.startTime))
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

    boolean this_present_endTime = true && this.isSetEndTime();
    boolean that_present_endTime = true && that.isSetEndTime();
    if (this_present_endTime || that_present_endTime) {
      if (!(this_present_endTime && that_present_endTime))
        return false;
      if (!this.endTime.equals(that.endTime))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(TDbSync_AdManager_Media_Buy_Partial_Date other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetMediaBuyID()).compareTo(other.isSetMediaBuyID());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMediaBuyID()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.mediaBuyID, other.mediaBuyID);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetStartTime()).compareTo(other.isSetStartTime());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStartTime()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.startTime, other.startTime);
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
    lastComparison = Boolean.valueOf(isSetEndTime()).compareTo(other.isSetEndTime());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEndTime()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.endTime, other.endTime);
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
    StringBuilder sb = new StringBuilder("TDbSync_AdManager_Media_Buy_Partial_Date(");
    boolean first = true;

    sb.append("mediaBuyID:");
    sb.append(this.mediaBuyID);
    first = false;
    if (!first) sb.append(", ");
    sb.append("startTime:");
    if (this.startTime == null) {
      sb.append("null");
    } else {
      sb.append(this.startTime);
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
    if (!first) sb.append(", ");
    sb.append("endTime:");
    if (this.endTime == null) {
      sb.append("null");
    } else {
      sb.append(this.endTime);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'mediaBuyID' because it's a primitive and you chose the non-beans generator.
    if (startTime == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'startTime' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'status' because it's a primitive and you chose the non-beans generator.
    if (lastChanged == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'lastChanged' was not present! Struct: " + toString());
    }
    if (endTime == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'endTime' was not present! Struct: " + toString());
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

  private static class TDbSync_AdManager_Media_Buy_Partial_DateStandardSchemeFactory implements SchemeFactory {
    public TDbSync_AdManager_Media_Buy_Partial_DateStandardScheme getScheme() {
      return new TDbSync_AdManager_Media_Buy_Partial_DateStandardScheme();
    }
  }

  private static class TDbSync_AdManager_Media_Buy_Partial_DateStandardScheme extends StandardScheme<TDbSync_AdManager_Media_Buy_Partial_Date> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TDbSync_AdManager_Media_Buy_Partial_Date struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // MEDIA_BUY_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.mediaBuyID = iprot.readI32();
              struct.setMediaBuyIDIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // START_TIME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.startTime = iprot.readString();
              struct.setStartTimeIsSet(true);
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
          case 5: // END_TIME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.endTime = iprot.readString();
              struct.setEndTimeIsSet(true);
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
      if (!struct.isSetMediaBuyID()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'mediaBuyID' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetStatus()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'status' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, TDbSync_AdManager_Media_Buy_Partial_Date struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(MEDIA_BUY_ID_FIELD_DESC);
      oprot.writeI32(struct.mediaBuyID);
      oprot.writeFieldEnd();
      if (struct.startTime != null) {
        oprot.writeFieldBegin(START_TIME_FIELD_DESC);
        oprot.writeString(struct.startTime);
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
      if (struct.endTime != null) {
        oprot.writeFieldBegin(END_TIME_FIELD_DESC);
        oprot.writeString(struct.endTime);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TDbSync_AdManager_Media_Buy_Partial_DateTupleSchemeFactory implements SchemeFactory {
    public TDbSync_AdManager_Media_Buy_Partial_DateTupleScheme getScheme() {
      return new TDbSync_AdManager_Media_Buy_Partial_DateTupleScheme();
    }
  }

  private static class TDbSync_AdManager_Media_Buy_Partial_DateTupleScheme extends TupleScheme<TDbSync_AdManager_Media_Buy_Partial_Date> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TDbSync_AdManager_Media_Buy_Partial_Date struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.mediaBuyID);
      oprot.writeString(struct.startTime);
      oprot.writeI32(struct.status);
      oprot.writeString(struct.lastChanged);
      oprot.writeString(struct.endTime);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TDbSync_AdManager_Media_Buy_Partial_Date struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.mediaBuyID = iprot.readI32();
      struct.setMediaBuyIDIsSet(true);
      struct.startTime = iprot.readString();
      struct.setStartTimeIsSet(true);
      struct.status = iprot.readI32();
      struct.setStatusIsSet(true);
      struct.lastChanged = iprot.readString();
      struct.setLastChangedIsSet(true);
      struct.endTime = iprot.readString();
      struct.setEndTimeIsSet(true);
    }
  }

}

