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

public class TDbSync_Dsp_Adchina_Mapping implements org.apache.thrift.TBase<TDbSync_Dsp_Adchina_Mapping, TDbSync_Dsp_Adchina_Mapping._Fields>, java.io.Serializable, Cloneable, Comparable<TDbSync_Dsp_Adchina_Mapping> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TDbSync_Dsp_Adchina_Mapping");

  private static final org.apache.thrift.protocol.TField ID_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("IdType", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField DSP_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("DspID", org.apache.thrift.protocol.TType.I64, (short)2);
  private static final org.apache.thrift.protocol.TField ADCHINA_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("AdchinaID", org.apache.thrift.protocol.TType.I64, (short)3);
  private static final org.apache.thrift.protocol.TField STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("Status", org.apache.thrift.protocol.TType.I32, (short)4);
  private static final org.apache.thrift.protocol.TField LAST_CHANGED_FIELD_DESC = new org.apache.thrift.protocol.TField("lastChanged", org.apache.thrift.protocol.TType.STRING, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TDbSync_Dsp_Adchina_MappingStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TDbSync_Dsp_Adchina_MappingTupleSchemeFactory());
  }

  public int IdType; // required
  public long DspID; // required
  public long AdchinaID; // required
  public int Status; // required
  public String lastChanged; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ID_TYPE((short)1, "IdType"),
    DSP_ID((short)2, "DspID"),
    ADCHINA_ID((short)3, "AdchinaID"),
    STATUS((short)4, "Status"),
    LAST_CHANGED((short)5, "lastChanged");

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
        case 1: // ID_TYPE
          return ID_TYPE;
        case 2: // DSP_ID
          return DSP_ID;
        case 3: // ADCHINA_ID
          return ADCHINA_ID;
        case 4: // STATUS
          return STATUS;
        case 5: // LAST_CHANGED
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
  private static final int __IDTYPE_ISSET_ID = 0;
  private static final int __DSPID_ISSET_ID = 1;
  private static final int __ADCHINAID_ISSET_ID = 2;
  private static final int __STATUS_ISSET_ID = 3;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ID_TYPE, new org.apache.thrift.meta_data.FieldMetaData("IdType", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.DSP_ID, new org.apache.thrift.meta_data.FieldMetaData("DspID", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.ADCHINA_ID, new org.apache.thrift.meta_data.FieldMetaData("AdchinaID", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.STATUS, new org.apache.thrift.meta_data.FieldMetaData("Status", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.LAST_CHANGED, new org.apache.thrift.meta_data.FieldMetaData("lastChanged", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TDbSync_Dsp_Adchina_Mapping.class, metaDataMap);
  }

  public TDbSync_Dsp_Adchina_Mapping() {
  }

  public TDbSync_Dsp_Adchina_Mapping(
    int IdType,
    long DspID,
    long AdchinaID,
    int Status,
    String lastChanged)
  {
    this();
    this.IdType = IdType;
    setIdTypeIsSet(true);
    this.DspID = DspID;
    setDspIDIsSet(true);
    this.AdchinaID = AdchinaID;
    setAdchinaIDIsSet(true);
    this.Status = Status;
    setStatusIsSet(true);
    this.lastChanged = lastChanged;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TDbSync_Dsp_Adchina_Mapping(TDbSync_Dsp_Adchina_Mapping other) {
    __isset_bitfield = other.__isset_bitfield;
    this.IdType = other.IdType;
    this.DspID = other.DspID;
    this.AdchinaID = other.AdchinaID;
    this.Status = other.Status;
    if (other.isSetLastChanged()) {
      this.lastChanged = other.lastChanged;
    }
  }

  public TDbSync_Dsp_Adchina_Mapping deepCopy() {
    return new TDbSync_Dsp_Adchina_Mapping(this);
  }

  @Override
  public void clear() {
    setIdTypeIsSet(false);
    this.IdType = 0;
    setDspIDIsSet(false);
    this.DspID = 0;
    setAdchinaIDIsSet(false);
    this.AdchinaID = 0;
    setStatusIsSet(false);
    this.Status = 0;
    this.lastChanged = null;
  }

  public int getIdType() {
    return this.IdType;
  }

  public TDbSync_Dsp_Adchina_Mapping setIdType(int IdType) {
    this.IdType = IdType;
    setIdTypeIsSet(true);
    return this;
  }

  public void unsetIdType() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __IDTYPE_ISSET_ID);
  }

  /** Returns true if field IdType is set (has been assigned a value) and false otherwise */
  public boolean isSetIdType() {
    return EncodingUtils.testBit(__isset_bitfield, __IDTYPE_ISSET_ID);
  }

  public void setIdTypeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __IDTYPE_ISSET_ID, value);
  }

  public long getDspID() {
    return this.DspID;
  }

  public TDbSync_Dsp_Adchina_Mapping setDspID(long DspID) {
    this.DspID = DspID;
    setDspIDIsSet(true);
    return this;
  }

  public void unsetDspID() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __DSPID_ISSET_ID);
  }

  /** Returns true if field DspID is set (has been assigned a value) and false otherwise */
  public boolean isSetDspID() {
    return EncodingUtils.testBit(__isset_bitfield, __DSPID_ISSET_ID);
  }

  public void setDspIDIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __DSPID_ISSET_ID, value);
  }

  public long getAdchinaID() {
    return this.AdchinaID;
  }

  public TDbSync_Dsp_Adchina_Mapping setAdchinaID(long AdchinaID) {
    this.AdchinaID = AdchinaID;
    setAdchinaIDIsSet(true);
    return this;
  }

  public void unsetAdchinaID() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ADCHINAID_ISSET_ID);
  }

  /** Returns true if field AdchinaID is set (has been assigned a value) and false otherwise */
  public boolean isSetAdchinaID() {
    return EncodingUtils.testBit(__isset_bitfield, __ADCHINAID_ISSET_ID);
  }

  public void setAdchinaIDIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ADCHINAID_ISSET_ID, value);
  }

  public int getStatus() {
    return this.Status;
  }

  public TDbSync_Dsp_Adchina_Mapping setStatus(int Status) {
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

  public TDbSync_Dsp_Adchina_Mapping setLastChanged(String lastChanged) {
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
    case ID_TYPE:
      if (value == null) {
        unsetIdType();
      } else {
        setIdType((Integer)value);
      }
      break;

    case DSP_ID:
      if (value == null) {
        unsetDspID();
      } else {
        setDspID((Long)value);
      }
      break;

    case ADCHINA_ID:
      if (value == null) {
        unsetAdchinaID();
      } else {
        setAdchinaID((Long)value);
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
    case ID_TYPE:
      return Integer.valueOf(getIdType());

    case DSP_ID:
      return Long.valueOf(getDspID());

    case ADCHINA_ID:
      return Long.valueOf(getAdchinaID());

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
    case ID_TYPE:
      return isSetIdType();
    case DSP_ID:
      return isSetDspID();
    case ADCHINA_ID:
      return isSetAdchinaID();
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
    if (that instanceof TDbSync_Dsp_Adchina_Mapping)
      return this.equals((TDbSync_Dsp_Adchina_Mapping)that);
    return false;
  }

  public boolean equals(TDbSync_Dsp_Adchina_Mapping that) {
    if (that == null)
      return false;

    boolean this_present_IdType = true;
    boolean that_present_IdType = true;
    if (this_present_IdType || that_present_IdType) {
      if (!(this_present_IdType && that_present_IdType))
        return false;
      if (this.IdType != that.IdType)
        return false;
    }

    boolean this_present_DspID = true;
    boolean that_present_DspID = true;
    if (this_present_DspID || that_present_DspID) {
      if (!(this_present_DspID && that_present_DspID))
        return false;
      if (this.DspID != that.DspID)
        return false;
    }

    boolean this_present_AdchinaID = true;
    boolean that_present_AdchinaID = true;
    if (this_present_AdchinaID || that_present_AdchinaID) {
      if (!(this_present_AdchinaID && that_present_AdchinaID))
        return false;
      if (this.AdchinaID != that.AdchinaID)
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

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(TDbSync_Dsp_Adchina_Mapping other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetIdType()).compareTo(other.isSetIdType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIdType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.IdType, other.IdType);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDspID()).compareTo(other.isSetDspID());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDspID()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.DspID, other.DspID);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAdchinaID()).compareTo(other.isSetAdchinaID());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAdchinaID()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.AdchinaID, other.AdchinaID);
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
    StringBuilder sb = new StringBuilder("TDbSync_Dsp_Adchina_Mapping(");
    boolean first = true;

    sb.append("IdType:");
    sb.append(this.IdType);
    first = false;
    if (!first) sb.append(", ");
    sb.append("DspID:");
    sb.append(this.DspID);
    first = false;
    if (!first) sb.append(", ");
    sb.append("AdchinaID:");
    sb.append(this.AdchinaID);
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
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'IdType' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'DspID' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'AdchinaID' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'Status' because it's a primitive and you chose the non-beans generator.
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

  private static class TDbSync_Dsp_Adchina_MappingStandardSchemeFactory implements SchemeFactory {
    public TDbSync_Dsp_Adchina_MappingStandardScheme getScheme() {
      return new TDbSync_Dsp_Adchina_MappingStandardScheme();
    }
  }

  private static class TDbSync_Dsp_Adchina_MappingStandardScheme extends StandardScheme<TDbSync_Dsp_Adchina_Mapping> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TDbSync_Dsp_Adchina_Mapping struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ID_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.IdType = iprot.readI32();
              struct.setIdTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // DSP_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.DspID = iprot.readI64();
              struct.setDspIDIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // ADCHINA_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.AdchinaID = iprot.readI64();
              struct.setAdchinaIDIsSet(true);
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
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      if (!struct.isSetIdType()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'IdType' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetDspID()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'DspID' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetAdchinaID()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'AdchinaID' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetStatus()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'Status' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, TDbSync_Dsp_Adchina_Mapping struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(ID_TYPE_FIELD_DESC);
      oprot.writeI32(struct.IdType);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(DSP_ID_FIELD_DESC);
      oprot.writeI64(struct.DspID);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(ADCHINA_ID_FIELD_DESC);
      oprot.writeI64(struct.AdchinaID);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(STATUS_FIELD_DESC);
      oprot.writeI32(struct.Status);
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

  private static class TDbSync_Dsp_Adchina_MappingTupleSchemeFactory implements SchemeFactory {
    public TDbSync_Dsp_Adchina_MappingTupleScheme getScheme() {
      return new TDbSync_Dsp_Adchina_MappingTupleScheme();
    }
  }

  private static class TDbSync_Dsp_Adchina_MappingTupleScheme extends TupleScheme<TDbSync_Dsp_Adchina_Mapping> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TDbSync_Dsp_Adchina_Mapping struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.IdType);
      oprot.writeI64(struct.DspID);
      oprot.writeI64(struct.AdchinaID);
      oprot.writeI32(struct.Status);
      oprot.writeString(struct.lastChanged);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TDbSync_Dsp_Adchina_Mapping struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.IdType = iprot.readI32();
      struct.setIdTypeIsSet(true);
      struct.DspID = iprot.readI64();
      struct.setDspIDIsSet(true);
      struct.AdchinaID = iprot.readI64();
      struct.setAdchinaIDIsSet(true);
      struct.Status = iprot.readI32();
      struct.setStatusIsSet(true);
      struct.lastChanged = iprot.readString();
      struct.setLastChangedIsSet(true);
    }
  }

}

