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

public class TDbSync_Dsp_Strategy_Creative_Weight implements org.apache.thrift.TBase<TDbSync_Dsp_Strategy_Creative_Weight, TDbSync_Dsp_Strategy_Creative_Weight._Fields>, java.io.Serializable, Cloneable, Comparable<TDbSync_Dsp_Strategy_Creative_Weight> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TDbSync_Dsp_Strategy_Creative_Weight");

  private static final org.apache.thrift.protocol.TField STRATEGY_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("strategyID", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField CREATIVE_CONCEPT_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("creativeConceptID", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField WEIGHT_FIELD_DESC = new org.apache.thrift.protocol.TField("weight", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("Status", org.apache.thrift.protocol.TType.I32, (short)4);
  private static final org.apache.thrift.protocol.TField LAST_CHANGED_FIELD_DESC = new org.apache.thrift.protocol.TField("lastChanged", org.apache.thrift.protocol.TType.STRING, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TDbSync_Dsp_Strategy_Creative_WeightStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TDbSync_Dsp_Strategy_Creative_WeightTupleSchemeFactory());
  }

  public int strategyID; // required
  public int creativeConceptID; // required
  public String weight; // required
  public int Status; // required
  public String lastChanged; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    STRATEGY_ID((short)1, "strategyID"),
    CREATIVE_CONCEPT_ID((short)2, "creativeConceptID"),
    WEIGHT((short)3, "weight"),
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
        case 1: // STRATEGY_ID
          return STRATEGY_ID;
        case 2: // CREATIVE_CONCEPT_ID
          return CREATIVE_CONCEPT_ID;
        case 3: // WEIGHT
          return WEIGHT;
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
  private static final int __STRATEGYID_ISSET_ID = 0;
  private static final int __CREATIVECONCEPTID_ISSET_ID = 1;
  private static final int __STATUS_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.STRATEGY_ID, new org.apache.thrift.meta_data.FieldMetaData("strategyID", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.CREATIVE_CONCEPT_ID, new org.apache.thrift.meta_data.FieldMetaData("creativeConceptID", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.WEIGHT, new org.apache.thrift.meta_data.FieldMetaData("weight", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.STATUS, new org.apache.thrift.meta_data.FieldMetaData("Status", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.LAST_CHANGED, new org.apache.thrift.meta_data.FieldMetaData("lastChanged", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TDbSync_Dsp_Strategy_Creative_Weight.class, metaDataMap);
  }

  public TDbSync_Dsp_Strategy_Creative_Weight() {
  }

  public TDbSync_Dsp_Strategy_Creative_Weight(
    int strategyID,
    int creativeConceptID,
    String weight,
    int Status,
    String lastChanged)
  {
    this();
    this.strategyID = strategyID;
    setStrategyIDIsSet(true);
    this.creativeConceptID = creativeConceptID;
    setCreativeConceptIDIsSet(true);
    this.weight = weight;
    this.Status = Status;
    setStatusIsSet(true);
    this.lastChanged = lastChanged;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TDbSync_Dsp_Strategy_Creative_Weight(TDbSync_Dsp_Strategy_Creative_Weight other) {
    __isset_bitfield = other.__isset_bitfield;
    this.strategyID = other.strategyID;
    this.creativeConceptID = other.creativeConceptID;
    if (other.isSetWeight()) {
      this.weight = other.weight;
    }
    this.Status = other.Status;
    if (other.isSetLastChanged()) {
      this.lastChanged = other.lastChanged;
    }
  }

  public TDbSync_Dsp_Strategy_Creative_Weight deepCopy() {
    return new TDbSync_Dsp_Strategy_Creative_Weight(this);
  }

  @Override
  public void clear() {
    setStrategyIDIsSet(false);
    this.strategyID = 0;
    setCreativeConceptIDIsSet(false);
    this.creativeConceptID = 0;
    this.weight = null;
    setStatusIsSet(false);
    this.Status = 0;
    this.lastChanged = null;
  }

  public int getStrategyID() {
    return this.strategyID;
  }

  public TDbSync_Dsp_Strategy_Creative_Weight setStrategyID(int strategyID) {
    this.strategyID = strategyID;
    setStrategyIDIsSet(true);
    return this;
  }

  public void unsetStrategyID() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __STRATEGYID_ISSET_ID);
  }

  /** Returns true if field strategyID is set (has been assigned a value) and false otherwise */
  public boolean isSetStrategyID() {
    return EncodingUtils.testBit(__isset_bitfield, __STRATEGYID_ISSET_ID);
  }

  public void setStrategyIDIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __STRATEGYID_ISSET_ID, value);
  }

  public int getCreativeConceptID() {
    return this.creativeConceptID;
  }

  public TDbSync_Dsp_Strategy_Creative_Weight setCreativeConceptID(int creativeConceptID) {
    this.creativeConceptID = creativeConceptID;
    setCreativeConceptIDIsSet(true);
    return this;
  }

  public void unsetCreativeConceptID() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __CREATIVECONCEPTID_ISSET_ID);
  }

  /** Returns true if field creativeConceptID is set (has been assigned a value) and false otherwise */
  public boolean isSetCreativeConceptID() {
    return EncodingUtils.testBit(__isset_bitfield, __CREATIVECONCEPTID_ISSET_ID);
  }

  public void setCreativeConceptIDIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __CREATIVECONCEPTID_ISSET_ID, value);
  }

  public String getWeight() {
    return this.weight;
  }

  public TDbSync_Dsp_Strategy_Creative_Weight setWeight(String weight) {
    this.weight = weight;
    return this;
  }

  public void unsetWeight() {
    this.weight = null;
  }

  /** Returns true if field weight is set (has been assigned a value) and false otherwise */
  public boolean isSetWeight() {
    return this.weight != null;
  }

  public void setWeightIsSet(boolean value) {
    if (!value) {
      this.weight = null;
    }
  }

  public int getStatus() {
    return this.Status;
  }

  public TDbSync_Dsp_Strategy_Creative_Weight setStatus(int Status) {
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

  public TDbSync_Dsp_Strategy_Creative_Weight setLastChanged(String lastChanged) {
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
    case STRATEGY_ID:
      if (value == null) {
        unsetStrategyID();
      } else {
        setStrategyID((Integer)value);
      }
      break;

    case CREATIVE_CONCEPT_ID:
      if (value == null) {
        unsetCreativeConceptID();
      } else {
        setCreativeConceptID((Integer)value);
      }
      break;

    case WEIGHT:
      if (value == null) {
        unsetWeight();
      } else {
        setWeight((String)value);
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
    case STRATEGY_ID:
      return Integer.valueOf(getStrategyID());

    case CREATIVE_CONCEPT_ID:
      return Integer.valueOf(getCreativeConceptID());

    case WEIGHT:
      return getWeight();

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
    case STRATEGY_ID:
      return isSetStrategyID();
    case CREATIVE_CONCEPT_ID:
      return isSetCreativeConceptID();
    case WEIGHT:
      return isSetWeight();
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
    if (that instanceof TDbSync_Dsp_Strategy_Creative_Weight)
      return this.equals((TDbSync_Dsp_Strategy_Creative_Weight)that);
    return false;
  }

  public boolean equals(TDbSync_Dsp_Strategy_Creative_Weight that) {
    if (that == null)
      return false;

    boolean this_present_strategyID = true;
    boolean that_present_strategyID = true;
    if (this_present_strategyID || that_present_strategyID) {
      if (!(this_present_strategyID && that_present_strategyID))
        return false;
      if (this.strategyID != that.strategyID)
        return false;
    }

    boolean this_present_creativeConceptID = true;
    boolean that_present_creativeConceptID = true;
    if (this_present_creativeConceptID || that_present_creativeConceptID) {
      if (!(this_present_creativeConceptID && that_present_creativeConceptID))
        return false;
      if (this.creativeConceptID != that.creativeConceptID)
        return false;
    }

    boolean this_present_weight = true && this.isSetWeight();
    boolean that_present_weight = true && that.isSetWeight();
    if (this_present_weight || that_present_weight) {
      if (!(this_present_weight && that_present_weight))
        return false;
      if (!this.weight.equals(that.weight))
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
  public int compareTo(TDbSync_Dsp_Strategy_Creative_Weight other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetStrategyID()).compareTo(other.isSetStrategyID());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStrategyID()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.strategyID, other.strategyID);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCreativeConceptID()).compareTo(other.isSetCreativeConceptID());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCreativeConceptID()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.creativeConceptID, other.creativeConceptID);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetWeight()).compareTo(other.isSetWeight());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetWeight()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.weight, other.weight);
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
    StringBuilder sb = new StringBuilder("TDbSync_Dsp_Strategy_Creative_Weight(");
    boolean first = true;

    sb.append("strategyID:");
    sb.append(this.strategyID);
    first = false;
    if (!first) sb.append(", ");
    sb.append("creativeConceptID:");
    sb.append(this.creativeConceptID);
    first = false;
    if (!first) sb.append(", ");
    sb.append("weight:");
    if (this.weight == null) {
      sb.append("null");
    } else {
      sb.append(this.weight);
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
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'strategyID' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'creativeConceptID' because it's a primitive and you chose the non-beans generator.
    if (weight == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'weight' was not present! Struct: " + toString());
    }
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

  private static class TDbSync_Dsp_Strategy_Creative_WeightStandardSchemeFactory implements SchemeFactory {
    public TDbSync_Dsp_Strategy_Creative_WeightStandardScheme getScheme() {
      return new TDbSync_Dsp_Strategy_Creative_WeightStandardScheme();
    }
  }

  private static class TDbSync_Dsp_Strategy_Creative_WeightStandardScheme extends StandardScheme<TDbSync_Dsp_Strategy_Creative_Weight> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TDbSync_Dsp_Strategy_Creative_Weight struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // STRATEGY_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.strategyID = iprot.readI32();
              struct.setStrategyIDIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // CREATIVE_CONCEPT_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.creativeConceptID = iprot.readI32();
              struct.setCreativeConceptIDIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // WEIGHT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.weight = iprot.readString();
              struct.setWeightIsSet(true);
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
      if (!struct.isSetStrategyID()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'strategyID' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetCreativeConceptID()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'creativeConceptID' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetStatus()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'Status' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, TDbSync_Dsp_Strategy_Creative_Weight struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(STRATEGY_ID_FIELD_DESC);
      oprot.writeI32(struct.strategyID);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(CREATIVE_CONCEPT_ID_FIELD_DESC);
      oprot.writeI32(struct.creativeConceptID);
      oprot.writeFieldEnd();
      if (struct.weight != null) {
        oprot.writeFieldBegin(WEIGHT_FIELD_DESC);
        oprot.writeString(struct.weight);
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
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TDbSync_Dsp_Strategy_Creative_WeightTupleSchemeFactory implements SchemeFactory {
    public TDbSync_Dsp_Strategy_Creative_WeightTupleScheme getScheme() {
      return new TDbSync_Dsp_Strategy_Creative_WeightTupleScheme();
    }
  }

  private static class TDbSync_Dsp_Strategy_Creative_WeightTupleScheme extends TupleScheme<TDbSync_Dsp_Strategy_Creative_Weight> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TDbSync_Dsp_Strategy_Creative_Weight struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.strategyID);
      oprot.writeI32(struct.creativeConceptID);
      oprot.writeString(struct.weight);
      oprot.writeI32(struct.Status);
      oprot.writeString(struct.lastChanged);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TDbSync_Dsp_Strategy_Creative_Weight struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.strategyID = iprot.readI32();
      struct.setStrategyIDIsSet(true);
      struct.creativeConceptID = iprot.readI32();
      struct.setCreativeConceptIDIsSet(true);
      struct.weight = iprot.readString();
      struct.setWeightIsSet(true);
      struct.Status = iprot.readI32();
      struct.setStatusIsSet(true);
      struct.lastChanged = iprot.readString();
      struct.setLastChangedIsSet(true);
    }
  }

}

