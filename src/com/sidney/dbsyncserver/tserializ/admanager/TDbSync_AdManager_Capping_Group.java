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

public class TDbSync_AdManager_Capping_Group implements org.apache.thrift.TBase<TDbSync_AdManager_Capping_Group, TDbSync_AdManager_Capping_Group._Fields>, java.io.Serializable, Cloneable, Comparable<TDbSync_AdManager_Capping_Group> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TDbSync_AdManager_Capping_Group");

  private static final org.apache.thrift.protocol.TField GROUP_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("groupID", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("status", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField LAST_CHANGED_FIELD_DESC = new org.apache.thrift.protocol.TField("lastChanged", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField CAPPING_IDS_FIELD_DESC = new org.apache.thrift.protocol.TField("cappingIDs", org.apache.thrift.protocol.TType.STRING, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TDbSync_AdManager_Capping_GroupStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TDbSync_AdManager_Capping_GroupTupleSchemeFactory());
  }

  public int groupID; // required
  public int status; // required
  public String lastChanged; // required
  public String cappingIDs; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    GROUP_ID((short)1, "groupID"),
    STATUS((short)2, "status"),
    LAST_CHANGED((short)3, "lastChanged"),
    CAPPING_IDS((short)4, "cappingIDs");

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
        case 1: // GROUP_ID
          return GROUP_ID;
        case 2: // STATUS
          return STATUS;
        case 3: // LAST_CHANGED
          return LAST_CHANGED;
        case 4: // CAPPING_IDS
          return CAPPING_IDS;
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
  private static final int __GROUPID_ISSET_ID = 0;
  private static final int __STATUS_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.GROUP_ID, new org.apache.thrift.meta_data.FieldMetaData("groupID", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.STATUS, new org.apache.thrift.meta_data.FieldMetaData("status", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.LAST_CHANGED, new org.apache.thrift.meta_data.FieldMetaData("lastChanged", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.CAPPING_IDS, new org.apache.thrift.meta_data.FieldMetaData("cappingIDs", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TDbSync_AdManager_Capping_Group.class, metaDataMap);
  }

  public TDbSync_AdManager_Capping_Group() {
  }

  public TDbSync_AdManager_Capping_Group(
    int groupID,
    int status,
    String lastChanged,
    String cappingIDs)
  {
    this();
    this.groupID = groupID;
    setGroupIDIsSet(true);
    this.status = status;
    setStatusIsSet(true);
    this.lastChanged = lastChanged;
    this.cappingIDs = cappingIDs;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TDbSync_AdManager_Capping_Group(TDbSync_AdManager_Capping_Group other) {
    __isset_bitfield = other.__isset_bitfield;
    this.groupID = other.groupID;
    this.status = other.status;
    if (other.isSetLastChanged()) {
      this.lastChanged = other.lastChanged;
    }
    if (other.isSetCappingIDs()) {
      this.cappingIDs = other.cappingIDs;
    }
  }

  public TDbSync_AdManager_Capping_Group deepCopy() {
    return new TDbSync_AdManager_Capping_Group(this);
  }

  @Override
  public void clear() {
    setGroupIDIsSet(false);
    this.groupID = 0;
    setStatusIsSet(false);
    this.status = 0;
    this.lastChanged = null;
    this.cappingIDs = null;
  }

  public int getGroupID() {
    return this.groupID;
  }

  public TDbSync_AdManager_Capping_Group setGroupID(int groupID) {
    this.groupID = groupID;
    setGroupIDIsSet(true);
    return this;
  }

  public void unsetGroupID() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __GROUPID_ISSET_ID);
  }

  /** Returns true if field groupID is set (has been assigned a value) and false otherwise */
  public boolean isSetGroupID() {
    return EncodingUtils.testBit(__isset_bitfield, __GROUPID_ISSET_ID);
  }

  public void setGroupIDIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __GROUPID_ISSET_ID, value);
  }

  public int getStatus() {
    return this.status;
  }

  public TDbSync_AdManager_Capping_Group setStatus(int status) {
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

  public TDbSync_AdManager_Capping_Group setLastChanged(String lastChanged) {
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

  public String getCappingIDs() {
    return this.cappingIDs;
  }

  public TDbSync_AdManager_Capping_Group setCappingIDs(String cappingIDs) {
    this.cappingIDs = cappingIDs;
    return this;
  }

  public void unsetCappingIDs() {
    this.cappingIDs = null;
  }

  /** Returns true if field cappingIDs is set (has been assigned a value) and false otherwise */
  public boolean isSetCappingIDs() {
    return this.cappingIDs != null;
  }

  public void setCappingIDsIsSet(boolean value) {
    if (!value) {
      this.cappingIDs = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case GROUP_ID:
      if (value == null) {
        unsetGroupID();
      } else {
        setGroupID((Integer)value);
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

    case CAPPING_IDS:
      if (value == null) {
        unsetCappingIDs();
      } else {
        setCappingIDs((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case GROUP_ID:
      return Integer.valueOf(getGroupID());

    case STATUS:
      return Integer.valueOf(getStatus());

    case LAST_CHANGED:
      return getLastChanged();

    case CAPPING_IDS:
      return getCappingIDs();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case GROUP_ID:
      return isSetGroupID();
    case STATUS:
      return isSetStatus();
    case LAST_CHANGED:
      return isSetLastChanged();
    case CAPPING_IDS:
      return isSetCappingIDs();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TDbSync_AdManager_Capping_Group)
      return this.equals((TDbSync_AdManager_Capping_Group)that);
    return false;
  }

  public boolean equals(TDbSync_AdManager_Capping_Group that) {
    if (that == null)
      return false;

    boolean this_present_groupID = true;
    boolean that_present_groupID = true;
    if (this_present_groupID || that_present_groupID) {
      if (!(this_present_groupID && that_present_groupID))
        return false;
      if (this.groupID != that.groupID)
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

    boolean this_present_cappingIDs = true && this.isSetCappingIDs();
    boolean that_present_cappingIDs = true && that.isSetCappingIDs();
    if (this_present_cappingIDs || that_present_cappingIDs) {
      if (!(this_present_cappingIDs && that_present_cappingIDs))
        return false;
      if (!this.cappingIDs.equals(that.cappingIDs))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(TDbSync_AdManager_Capping_Group other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetGroupID()).compareTo(other.isSetGroupID());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetGroupID()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.groupID, other.groupID);
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
    lastComparison = Boolean.valueOf(isSetCappingIDs()).compareTo(other.isSetCappingIDs());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCappingIDs()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.cappingIDs, other.cappingIDs);
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
    StringBuilder sb = new StringBuilder("TDbSync_AdManager_Capping_Group(");
    boolean first = true;

    sb.append("groupID:");
    sb.append(this.groupID);
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
    sb.append("cappingIDs:");
    if (this.cappingIDs == null) {
      sb.append("null");
    } else {
      sb.append(this.cappingIDs);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'groupID' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'status' because it's a primitive and you chose the non-beans generator.
    if (lastChanged == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'lastChanged' was not present! Struct: " + toString());
    }
    if (cappingIDs == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'cappingIDs' was not present! Struct: " + toString());
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

  private static class TDbSync_AdManager_Capping_GroupStandardSchemeFactory implements SchemeFactory {
    public TDbSync_AdManager_Capping_GroupStandardScheme getScheme() {
      return new TDbSync_AdManager_Capping_GroupStandardScheme();
    }
  }

  private static class TDbSync_AdManager_Capping_GroupStandardScheme extends StandardScheme<TDbSync_AdManager_Capping_Group> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TDbSync_AdManager_Capping_Group struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // GROUP_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.groupID = iprot.readI32();
              struct.setGroupIDIsSet(true);
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
          case 4: // CAPPING_IDS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.cappingIDs = iprot.readString();
              struct.setCappingIDsIsSet(true);
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
      if (!struct.isSetGroupID()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'groupID' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetStatus()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'status' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, TDbSync_AdManager_Capping_Group struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(GROUP_ID_FIELD_DESC);
      oprot.writeI32(struct.groupID);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(STATUS_FIELD_DESC);
      oprot.writeI32(struct.status);
      oprot.writeFieldEnd();
      if (struct.lastChanged != null) {
        oprot.writeFieldBegin(LAST_CHANGED_FIELD_DESC);
        oprot.writeString(struct.lastChanged);
        oprot.writeFieldEnd();
      }
      if (struct.cappingIDs != null) {
        oprot.writeFieldBegin(CAPPING_IDS_FIELD_DESC);
        oprot.writeString(struct.cappingIDs);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TDbSync_AdManager_Capping_GroupTupleSchemeFactory implements SchemeFactory {
    public TDbSync_AdManager_Capping_GroupTupleScheme getScheme() {
      return new TDbSync_AdManager_Capping_GroupTupleScheme();
    }
  }

  private static class TDbSync_AdManager_Capping_GroupTupleScheme extends TupleScheme<TDbSync_AdManager_Capping_Group> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TDbSync_AdManager_Capping_Group struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.groupID);
      oprot.writeI32(struct.status);
      oprot.writeString(struct.lastChanged);
      oprot.writeString(struct.cappingIDs);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TDbSync_AdManager_Capping_Group struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.groupID = iprot.readI32();
      struct.setGroupIDIsSet(true);
      struct.status = iprot.readI32();
      struct.setStatusIsSet(true);
      struct.lastChanged = iprot.readString();
      struct.setLastChangedIsSet(true);
      struct.cappingIDs = iprot.readString();
      struct.setCappingIDsIsSet(true);
    }
  }

}

