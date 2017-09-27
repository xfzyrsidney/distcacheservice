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

public class TDbSync_Dsp_Aod_Campaign_Mapping implements org.apache.thrift.TBase<TDbSync_Dsp_Aod_Campaign_Mapping, TDbSync_Dsp_Aod_Campaign_Mapping._Fields>, java.io.Serializable, Cloneable, Comparable<TDbSync_Dsp_Aod_Campaign_Mapping> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TDbSync_Dsp_Aod_Campaign_Mapping");

  private static final org.apache.thrift.protocol.TField DSP_CAMPAIGN_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("dspCampaignId", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField AOD_CAMPAIGN_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("aodCampaignId", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("Status", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField LAST_CHANGED_FIELD_DESC = new org.apache.thrift.protocol.TField("lastChanged", org.apache.thrift.protocol.TType.STRING, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TDbSync_Dsp_Aod_Campaign_MappingStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TDbSync_Dsp_Aod_Campaign_MappingTupleSchemeFactory());
  }

  public int dspCampaignId; // required
  public int aodCampaignId; // required
  public int Status; // required
  public String lastChanged; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    DSP_CAMPAIGN_ID((short)1, "dspCampaignId"),
    AOD_CAMPAIGN_ID((short)2, "aodCampaignId"),
    STATUS((short)3, "Status"),
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
        case 1: // DSP_CAMPAIGN_ID
          return DSP_CAMPAIGN_ID;
        case 2: // AOD_CAMPAIGN_ID
          return AOD_CAMPAIGN_ID;
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
  private static final int __DSPCAMPAIGNID_ISSET_ID = 0;
  private static final int __AODCAMPAIGNID_ISSET_ID = 1;
  private static final int __STATUS_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.DSP_CAMPAIGN_ID, new org.apache.thrift.meta_data.FieldMetaData("dspCampaignId", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.AOD_CAMPAIGN_ID, new org.apache.thrift.meta_data.FieldMetaData("aodCampaignId", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.STATUS, new org.apache.thrift.meta_data.FieldMetaData("Status", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.LAST_CHANGED, new org.apache.thrift.meta_data.FieldMetaData("lastChanged", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TDbSync_Dsp_Aod_Campaign_Mapping.class, metaDataMap);
  }

  public TDbSync_Dsp_Aod_Campaign_Mapping() {
  }

  public TDbSync_Dsp_Aod_Campaign_Mapping(
    int dspCampaignId,
    int aodCampaignId,
    int Status,
    String lastChanged)
  {
    this();
    this.dspCampaignId = dspCampaignId;
    setDspCampaignIdIsSet(true);
    this.aodCampaignId = aodCampaignId;
    setAodCampaignIdIsSet(true);
    this.Status = Status;
    setStatusIsSet(true);
    this.lastChanged = lastChanged;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TDbSync_Dsp_Aod_Campaign_Mapping(TDbSync_Dsp_Aod_Campaign_Mapping other) {
    __isset_bitfield = other.__isset_bitfield;
    this.dspCampaignId = other.dspCampaignId;
    this.aodCampaignId = other.aodCampaignId;
    this.Status = other.Status;
    if (other.isSetLastChanged()) {
      this.lastChanged = other.lastChanged;
    }
  }

  public TDbSync_Dsp_Aod_Campaign_Mapping deepCopy() {
    return new TDbSync_Dsp_Aod_Campaign_Mapping(this);
  }

  @Override
  public void clear() {
    setDspCampaignIdIsSet(false);
    this.dspCampaignId = 0;
    setAodCampaignIdIsSet(false);
    this.aodCampaignId = 0;
    setStatusIsSet(false);
    this.Status = 0;
    this.lastChanged = null;
  }

  public int getDspCampaignId() {
    return this.dspCampaignId;
  }

  public TDbSync_Dsp_Aod_Campaign_Mapping setDspCampaignId(int dspCampaignId) {
    this.dspCampaignId = dspCampaignId;
    setDspCampaignIdIsSet(true);
    return this;
  }

  public void unsetDspCampaignId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __DSPCAMPAIGNID_ISSET_ID);
  }

  /** Returns true if field dspCampaignId is set (has been assigned a value) and false otherwise */
  public boolean isSetDspCampaignId() {
    return EncodingUtils.testBit(__isset_bitfield, __DSPCAMPAIGNID_ISSET_ID);
  }

  public void setDspCampaignIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __DSPCAMPAIGNID_ISSET_ID, value);
  }

  public int getAodCampaignId() {
    return this.aodCampaignId;
  }

  public TDbSync_Dsp_Aod_Campaign_Mapping setAodCampaignId(int aodCampaignId) {
    this.aodCampaignId = aodCampaignId;
    setAodCampaignIdIsSet(true);
    return this;
  }

  public void unsetAodCampaignId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __AODCAMPAIGNID_ISSET_ID);
  }

  /** Returns true if field aodCampaignId is set (has been assigned a value) and false otherwise */
  public boolean isSetAodCampaignId() {
    return EncodingUtils.testBit(__isset_bitfield, __AODCAMPAIGNID_ISSET_ID);
  }

  public void setAodCampaignIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __AODCAMPAIGNID_ISSET_ID, value);
  }

  public int getStatus() {
    return this.Status;
  }

  public TDbSync_Dsp_Aod_Campaign_Mapping setStatus(int Status) {
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

  public TDbSync_Dsp_Aod_Campaign_Mapping setLastChanged(String lastChanged) {
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
    case DSP_CAMPAIGN_ID:
      if (value == null) {
        unsetDspCampaignId();
      } else {
        setDspCampaignId((Integer)value);
      }
      break;

    case AOD_CAMPAIGN_ID:
      if (value == null) {
        unsetAodCampaignId();
      } else {
        setAodCampaignId((Integer)value);
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
    case DSP_CAMPAIGN_ID:
      return Integer.valueOf(getDspCampaignId());

    case AOD_CAMPAIGN_ID:
      return Integer.valueOf(getAodCampaignId());

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
    case DSP_CAMPAIGN_ID:
      return isSetDspCampaignId();
    case AOD_CAMPAIGN_ID:
      return isSetAodCampaignId();
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
    if (that instanceof TDbSync_Dsp_Aod_Campaign_Mapping)
      return this.equals((TDbSync_Dsp_Aod_Campaign_Mapping)that);
    return false;
  }

  public boolean equals(TDbSync_Dsp_Aod_Campaign_Mapping that) {
    if (that == null)
      return false;

    boolean this_present_dspCampaignId = true;
    boolean that_present_dspCampaignId = true;
    if (this_present_dspCampaignId || that_present_dspCampaignId) {
      if (!(this_present_dspCampaignId && that_present_dspCampaignId))
        return false;
      if (this.dspCampaignId != that.dspCampaignId)
        return false;
    }

    boolean this_present_aodCampaignId = true;
    boolean that_present_aodCampaignId = true;
    if (this_present_aodCampaignId || that_present_aodCampaignId) {
      if (!(this_present_aodCampaignId && that_present_aodCampaignId))
        return false;
      if (this.aodCampaignId != that.aodCampaignId)
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
  public int compareTo(TDbSync_Dsp_Aod_Campaign_Mapping other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetDspCampaignId()).compareTo(other.isSetDspCampaignId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDspCampaignId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.dspCampaignId, other.dspCampaignId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAodCampaignId()).compareTo(other.isSetAodCampaignId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAodCampaignId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.aodCampaignId, other.aodCampaignId);
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
    StringBuilder sb = new StringBuilder("TDbSync_Dsp_Aod_Campaign_Mapping(");
    boolean first = true;

    sb.append("dspCampaignId:");
    sb.append(this.dspCampaignId);
    first = false;
    if (!first) sb.append(", ");
    sb.append("aodCampaignId:");
    sb.append(this.aodCampaignId);
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
    // alas, we cannot check 'dspCampaignId' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'aodCampaignId' because it's a primitive and you chose the non-beans generator.
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

  private static class TDbSync_Dsp_Aod_Campaign_MappingStandardSchemeFactory implements SchemeFactory {
    public TDbSync_Dsp_Aod_Campaign_MappingStandardScheme getScheme() {
      return new TDbSync_Dsp_Aod_Campaign_MappingStandardScheme();
    }
  }

  private static class TDbSync_Dsp_Aod_Campaign_MappingStandardScheme extends StandardScheme<TDbSync_Dsp_Aod_Campaign_Mapping> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TDbSync_Dsp_Aod_Campaign_Mapping struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // DSP_CAMPAIGN_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.dspCampaignId = iprot.readI32();
              struct.setDspCampaignIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // AOD_CAMPAIGN_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.aodCampaignId = iprot.readI32();
              struct.setAodCampaignIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // STATUS
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.Status = iprot.readI32();
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
      if (!struct.isSetDspCampaignId()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'dspCampaignId' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetAodCampaignId()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'aodCampaignId' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetStatus()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'Status' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, TDbSync_Dsp_Aod_Campaign_Mapping struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(DSP_CAMPAIGN_ID_FIELD_DESC);
      oprot.writeI32(struct.dspCampaignId);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(AOD_CAMPAIGN_ID_FIELD_DESC);
      oprot.writeI32(struct.aodCampaignId);
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

  private static class TDbSync_Dsp_Aod_Campaign_MappingTupleSchemeFactory implements SchemeFactory {
    public TDbSync_Dsp_Aod_Campaign_MappingTupleScheme getScheme() {
      return new TDbSync_Dsp_Aod_Campaign_MappingTupleScheme();
    }
  }

  private static class TDbSync_Dsp_Aod_Campaign_MappingTupleScheme extends TupleScheme<TDbSync_Dsp_Aod_Campaign_Mapping> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TDbSync_Dsp_Aod_Campaign_Mapping struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.dspCampaignId);
      oprot.writeI32(struct.aodCampaignId);
      oprot.writeI32(struct.Status);
      oprot.writeString(struct.lastChanged);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TDbSync_Dsp_Aod_Campaign_Mapping struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.dspCampaignId = iprot.readI32();
      struct.setDspCampaignIdIsSet(true);
      struct.aodCampaignId = iprot.readI32();
      struct.setAodCampaignIdIsSet(true);
      struct.Status = iprot.readI32();
      struct.setStatusIsSet(true);
      struct.lastChanged = iprot.readString();
      struct.setLastChangedIsSet(true);
    }
  }

}
