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

public class TDbSync_Dsp_Standard_Audience_Category implements org.apache.thrift.TBase<TDbSync_Dsp_Standard_Audience_Category, TDbSync_Dsp_Standard_Audience_Category._Fields>, java.io.Serializable, Cloneable, Comparable<TDbSync_Dsp_Standard_Audience_Category> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TDbSync_Dsp_Standard_Audience_Category");

  private static final org.apache.thrift.protocol.TField STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("status", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField LAST_CHANGED_FIELD_DESC = new org.apache.thrift.protocol.TField("lastChanged", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField PARENT_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("parentID", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField AUDIENCE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("audienceID", org.apache.thrift.protocol.TType.I32, (short)4);
  private static final org.apache.thrift.protocol.TField AUDIENCE_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("audienceName", org.apache.thrift.protocol.TType.STRING, (short)5);
  private static final org.apache.thrift.protocol.TField AUDIENCE_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("audienceType", org.apache.thrift.protocol.TType.I32, (short)6);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TDbSync_Dsp_Standard_Audience_CategoryStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TDbSync_Dsp_Standard_Audience_CategoryTupleSchemeFactory());
  }

  public int status; // required
  public String lastChanged; // required
  public int parentID; // required
  public int audienceID; // required
  public String audienceName; // required
  public int audienceType; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    STATUS((short)1, "status"),
    LAST_CHANGED((short)2, "lastChanged"),
    PARENT_ID((short)3, "parentID"),
    AUDIENCE_ID((short)4, "audienceID"),
    AUDIENCE_NAME((short)5, "audienceName"),
    AUDIENCE_TYPE((short)6, "audienceType");

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
        case 1: // STATUS
          return STATUS;
        case 2: // LAST_CHANGED
          return LAST_CHANGED;
        case 3: // PARENT_ID
          return PARENT_ID;
        case 4: // AUDIENCE_ID
          return AUDIENCE_ID;
        case 5: // AUDIENCE_NAME
          return AUDIENCE_NAME;
        case 6: // AUDIENCE_TYPE
          return AUDIENCE_TYPE;
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
  private static final int __STATUS_ISSET_ID = 0;
  private static final int __PARENTID_ISSET_ID = 1;
  private static final int __AUDIENCEID_ISSET_ID = 2;
  private static final int __AUDIENCETYPE_ISSET_ID = 3;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.STATUS, new org.apache.thrift.meta_data.FieldMetaData("status", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.LAST_CHANGED, new org.apache.thrift.meta_data.FieldMetaData("lastChanged", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PARENT_ID, new org.apache.thrift.meta_data.FieldMetaData("parentID", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.AUDIENCE_ID, new org.apache.thrift.meta_data.FieldMetaData("audienceID", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.AUDIENCE_NAME, new org.apache.thrift.meta_data.FieldMetaData("audienceName", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.AUDIENCE_TYPE, new org.apache.thrift.meta_data.FieldMetaData("audienceType", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TDbSync_Dsp_Standard_Audience_Category.class, metaDataMap);
  }

  public TDbSync_Dsp_Standard_Audience_Category() {
  }

  public TDbSync_Dsp_Standard_Audience_Category(
    int status,
    String lastChanged,
    int parentID,
    int audienceID,
    String audienceName,
    int audienceType)
  {
    this();
    this.status = status;
    setStatusIsSet(true);
    this.lastChanged = lastChanged;
    this.parentID = parentID;
    setParentIDIsSet(true);
    this.audienceID = audienceID;
    setAudienceIDIsSet(true);
    this.audienceName = audienceName;
    this.audienceType = audienceType;
    setAudienceTypeIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TDbSync_Dsp_Standard_Audience_Category(TDbSync_Dsp_Standard_Audience_Category other) {
    __isset_bitfield = other.__isset_bitfield;
    this.status = other.status;
    if (other.isSetLastChanged()) {
      this.lastChanged = other.lastChanged;
    }
    this.parentID = other.parentID;
    this.audienceID = other.audienceID;
    if (other.isSetAudienceName()) {
      this.audienceName = other.audienceName;
    }
    this.audienceType = other.audienceType;
  }

  public TDbSync_Dsp_Standard_Audience_Category deepCopy() {
    return new TDbSync_Dsp_Standard_Audience_Category(this);
  }

  @Override
  public void clear() {
    setStatusIsSet(false);
    this.status = 0;
    this.lastChanged = null;
    setParentIDIsSet(false);
    this.parentID = 0;
    setAudienceIDIsSet(false);
    this.audienceID = 0;
    this.audienceName = null;
    setAudienceTypeIsSet(false);
    this.audienceType = 0;
  }

  public int getStatus() {
    return this.status;
  }

  public TDbSync_Dsp_Standard_Audience_Category setStatus(int status) {
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

  public TDbSync_Dsp_Standard_Audience_Category setLastChanged(String lastChanged) {
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

  public int getParentID() {
    return this.parentID;
  }

  public TDbSync_Dsp_Standard_Audience_Category setParentID(int parentID) {
    this.parentID = parentID;
    setParentIDIsSet(true);
    return this;
  }

  public void unsetParentID() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __PARENTID_ISSET_ID);
  }

  /** Returns true if field parentID is set (has been assigned a value) and false otherwise */
  public boolean isSetParentID() {
    return EncodingUtils.testBit(__isset_bitfield, __PARENTID_ISSET_ID);
  }

  public void setParentIDIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __PARENTID_ISSET_ID, value);
  }

  public int getAudienceID() {
    return this.audienceID;
  }

  public TDbSync_Dsp_Standard_Audience_Category setAudienceID(int audienceID) {
    this.audienceID = audienceID;
    setAudienceIDIsSet(true);
    return this;
  }

  public void unsetAudienceID() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __AUDIENCEID_ISSET_ID);
  }

  /** Returns true if field audienceID is set (has been assigned a value) and false otherwise */
  public boolean isSetAudienceID() {
    return EncodingUtils.testBit(__isset_bitfield, __AUDIENCEID_ISSET_ID);
  }

  public void setAudienceIDIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __AUDIENCEID_ISSET_ID, value);
  }

  public String getAudienceName() {
    return this.audienceName;
  }

  public TDbSync_Dsp_Standard_Audience_Category setAudienceName(String audienceName) {
    this.audienceName = audienceName;
    return this;
  }

  public void unsetAudienceName() {
    this.audienceName = null;
  }

  /** Returns true if field audienceName is set (has been assigned a value) and false otherwise */
  public boolean isSetAudienceName() {
    return this.audienceName != null;
  }

  public void setAudienceNameIsSet(boolean value) {
    if (!value) {
      this.audienceName = null;
    }
  }

  public int getAudienceType() {
    return this.audienceType;
  }

  public TDbSync_Dsp_Standard_Audience_Category setAudienceType(int audienceType) {
    this.audienceType = audienceType;
    setAudienceTypeIsSet(true);
    return this;
  }

  public void unsetAudienceType() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __AUDIENCETYPE_ISSET_ID);
  }

  /** Returns true if field audienceType is set (has been assigned a value) and false otherwise */
  public boolean isSetAudienceType() {
    return EncodingUtils.testBit(__isset_bitfield, __AUDIENCETYPE_ISSET_ID);
  }

  public void setAudienceTypeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __AUDIENCETYPE_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
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

    case PARENT_ID:
      if (value == null) {
        unsetParentID();
      } else {
        setParentID((Integer)value);
      }
      break;

    case AUDIENCE_ID:
      if (value == null) {
        unsetAudienceID();
      } else {
        setAudienceID((Integer)value);
      }
      break;

    case AUDIENCE_NAME:
      if (value == null) {
        unsetAudienceName();
      } else {
        setAudienceName((String)value);
      }
      break;

    case AUDIENCE_TYPE:
      if (value == null) {
        unsetAudienceType();
      } else {
        setAudienceType((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case STATUS:
      return Integer.valueOf(getStatus());

    case LAST_CHANGED:
      return getLastChanged();

    case PARENT_ID:
      return Integer.valueOf(getParentID());

    case AUDIENCE_ID:
      return Integer.valueOf(getAudienceID());

    case AUDIENCE_NAME:
      return getAudienceName();

    case AUDIENCE_TYPE:
      return Integer.valueOf(getAudienceType());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case STATUS:
      return isSetStatus();
    case LAST_CHANGED:
      return isSetLastChanged();
    case PARENT_ID:
      return isSetParentID();
    case AUDIENCE_ID:
      return isSetAudienceID();
    case AUDIENCE_NAME:
      return isSetAudienceName();
    case AUDIENCE_TYPE:
      return isSetAudienceType();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TDbSync_Dsp_Standard_Audience_Category)
      return this.equals((TDbSync_Dsp_Standard_Audience_Category)that);
    return false;
  }

  public boolean equals(TDbSync_Dsp_Standard_Audience_Category that) {
    if (that == null)
      return false;

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

    boolean this_present_parentID = true;
    boolean that_present_parentID = true;
    if (this_present_parentID || that_present_parentID) {
      if (!(this_present_parentID && that_present_parentID))
        return false;
      if (this.parentID != that.parentID)
        return false;
    }

    boolean this_present_audienceID = true;
    boolean that_present_audienceID = true;
    if (this_present_audienceID || that_present_audienceID) {
      if (!(this_present_audienceID && that_present_audienceID))
        return false;
      if (this.audienceID != that.audienceID)
        return false;
    }

    boolean this_present_audienceName = true && this.isSetAudienceName();
    boolean that_present_audienceName = true && that.isSetAudienceName();
    if (this_present_audienceName || that_present_audienceName) {
      if (!(this_present_audienceName && that_present_audienceName))
        return false;
      if (!this.audienceName.equals(that.audienceName))
        return false;
    }

    boolean this_present_audienceType = true;
    boolean that_present_audienceType = true;
    if (this_present_audienceType || that_present_audienceType) {
      if (!(this_present_audienceType && that_present_audienceType))
        return false;
      if (this.audienceType != that.audienceType)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(TDbSync_Dsp_Standard_Audience_Category other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

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
    lastComparison = Boolean.valueOf(isSetParentID()).compareTo(other.isSetParentID());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetParentID()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.parentID, other.parentID);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAudienceID()).compareTo(other.isSetAudienceID());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAudienceID()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.audienceID, other.audienceID);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAudienceName()).compareTo(other.isSetAudienceName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAudienceName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.audienceName, other.audienceName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAudienceType()).compareTo(other.isSetAudienceType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAudienceType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.audienceType, other.audienceType);
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
    StringBuilder sb = new StringBuilder("TDbSync_Dsp_Standard_Audience_Category(");
    boolean first = true;

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
    sb.append("parentID:");
    sb.append(this.parentID);
    first = false;
    if (!first) sb.append(", ");
    sb.append("audienceID:");
    sb.append(this.audienceID);
    first = false;
    if (!first) sb.append(", ");
    sb.append("audienceName:");
    if (this.audienceName == null) {
      sb.append("null");
    } else {
      sb.append(this.audienceName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("audienceType:");
    sb.append(this.audienceType);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'status' because it's a primitive and you chose the non-beans generator.
    if (lastChanged == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'lastChanged' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'parentID' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'audienceID' because it's a primitive and you chose the non-beans generator.
    if (audienceName == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'audienceName' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'audienceType' because it's a primitive and you chose the non-beans generator.
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

  private static class TDbSync_Dsp_Standard_Audience_CategoryStandardSchemeFactory implements SchemeFactory {
    public TDbSync_Dsp_Standard_Audience_CategoryStandardScheme getScheme() {
      return new TDbSync_Dsp_Standard_Audience_CategoryStandardScheme();
    }
  }

  private static class TDbSync_Dsp_Standard_Audience_CategoryStandardScheme extends StandardScheme<TDbSync_Dsp_Standard_Audience_Category> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TDbSync_Dsp_Standard_Audience_Category struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // STATUS
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.status = iprot.readI32();
              struct.setStatusIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // LAST_CHANGED
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.lastChanged = iprot.readString();
              struct.setLastChangedIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // PARENT_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.parentID = iprot.readI32();
              struct.setParentIDIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // AUDIENCE_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.audienceID = iprot.readI32();
              struct.setAudienceIDIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // AUDIENCE_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.audienceName = iprot.readString();
              struct.setAudienceNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // AUDIENCE_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.audienceType = iprot.readI32();
              struct.setAudienceTypeIsSet(true);
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
      if (!struct.isSetStatus()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'status' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetParentID()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'parentID' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetAudienceID()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'audienceID' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetAudienceType()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'audienceType' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, TDbSync_Dsp_Standard_Audience_Category struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(STATUS_FIELD_DESC);
      oprot.writeI32(struct.status);
      oprot.writeFieldEnd();
      if (struct.lastChanged != null) {
        oprot.writeFieldBegin(LAST_CHANGED_FIELD_DESC);
        oprot.writeString(struct.lastChanged);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(PARENT_ID_FIELD_DESC);
      oprot.writeI32(struct.parentID);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(AUDIENCE_ID_FIELD_DESC);
      oprot.writeI32(struct.audienceID);
      oprot.writeFieldEnd();
      if (struct.audienceName != null) {
        oprot.writeFieldBegin(AUDIENCE_NAME_FIELD_DESC);
        oprot.writeString(struct.audienceName);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(AUDIENCE_TYPE_FIELD_DESC);
      oprot.writeI32(struct.audienceType);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TDbSync_Dsp_Standard_Audience_CategoryTupleSchemeFactory implements SchemeFactory {
    public TDbSync_Dsp_Standard_Audience_CategoryTupleScheme getScheme() {
      return new TDbSync_Dsp_Standard_Audience_CategoryTupleScheme();
    }
  }

  private static class TDbSync_Dsp_Standard_Audience_CategoryTupleScheme extends TupleScheme<TDbSync_Dsp_Standard_Audience_Category> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TDbSync_Dsp_Standard_Audience_Category struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.status);
      oprot.writeString(struct.lastChanged);
      oprot.writeI32(struct.parentID);
      oprot.writeI32(struct.audienceID);
      oprot.writeString(struct.audienceName);
      oprot.writeI32(struct.audienceType);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TDbSync_Dsp_Standard_Audience_Category struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.status = iprot.readI32();
      struct.setStatusIsSet(true);
      struct.lastChanged = iprot.readString();
      struct.setLastChangedIsSet(true);
      struct.parentID = iprot.readI32();
      struct.setParentIDIsSet(true);
      struct.audienceID = iprot.readI32();
      struct.setAudienceIDIsSet(true);
      struct.audienceName = iprot.readString();
      struct.setAudienceNameIsSet(true);
      struct.audienceType = iprot.readI32();
      struct.setAudienceTypeIsSet(true);
    }
  }

}

