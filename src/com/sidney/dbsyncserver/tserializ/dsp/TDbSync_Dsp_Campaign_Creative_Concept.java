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

public class TDbSync_Dsp_Campaign_Creative_Concept implements org.apache.thrift.TBase<TDbSync_Dsp_Campaign_Creative_Concept, TDbSync_Dsp_Campaign_Creative_Concept._Fields>, java.io.Serializable, Cloneable, Comparable<TDbSync_Dsp_Campaign_Creative_Concept> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TDbSync_Dsp_Campaign_Creative_Concept");

  private static final org.apache.thrift.protocol.TField CONCEPT_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("conceptID", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("status", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField LAST_CHANGED_FIELD_DESC = new org.apache.thrift.protocol.TField("lastChanged", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField CONCEPT_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("conceptName", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField CAMPAIGN_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("campaignID", org.apache.thrift.protocol.TType.I32, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TDbSync_Dsp_Campaign_Creative_ConceptStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TDbSync_Dsp_Campaign_Creative_ConceptTupleSchemeFactory());
  }

  public int conceptID; // required
  public int status; // required
  public String lastChanged; // required
  public String conceptName; // required
  public int campaignID; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    CONCEPT_ID((short)1, "conceptID"),
    STATUS((short)2, "status"),
    LAST_CHANGED((short)3, "lastChanged"),
    CONCEPT_NAME((short)4, "conceptName"),
    CAMPAIGN_ID((short)5, "campaignID");

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
        case 1: // CONCEPT_ID
          return CONCEPT_ID;
        case 2: // STATUS
          return STATUS;
        case 3: // LAST_CHANGED
          return LAST_CHANGED;
        case 4: // CONCEPT_NAME
          return CONCEPT_NAME;
        case 5: // CAMPAIGN_ID
          return CAMPAIGN_ID;
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
  private static final int __CONCEPTID_ISSET_ID = 0;
  private static final int __STATUS_ISSET_ID = 1;
  private static final int __CAMPAIGNID_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.CONCEPT_ID, new org.apache.thrift.meta_data.FieldMetaData("conceptID", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.STATUS, new org.apache.thrift.meta_data.FieldMetaData("status", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.LAST_CHANGED, new org.apache.thrift.meta_data.FieldMetaData("lastChanged", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.CONCEPT_NAME, new org.apache.thrift.meta_data.FieldMetaData("conceptName", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.CAMPAIGN_ID, new org.apache.thrift.meta_data.FieldMetaData("campaignID", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TDbSync_Dsp_Campaign_Creative_Concept.class, metaDataMap);
  }

  public TDbSync_Dsp_Campaign_Creative_Concept() {
  }

  public TDbSync_Dsp_Campaign_Creative_Concept(
    int conceptID,
    int status,
    String lastChanged,
    String conceptName,
    int campaignID)
  {
    this();
    this.conceptID = conceptID;
    setConceptIDIsSet(true);
    this.status = status;
    setStatusIsSet(true);
    this.lastChanged = lastChanged;
    this.conceptName = conceptName;
    this.campaignID = campaignID;
    setCampaignIDIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TDbSync_Dsp_Campaign_Creative_Concept(TDbSync_Dsp_Campaign_Creative_Concept other) {
    __isset_bitfield = other.__isset_bitfield;
    this.conceptID = other.conceptID;
    this.status = other.status;
    if (other.isSetLastChanged()) {
      this.lastChanged = other.lastChanged;
    }
    if (other.isSetConceptName()) {
      this.conceptName = other.conceptName;
    }
    this.campaignID = other.campaignID;
  }

  public TDbSync_Dsp_Campaign_Creative_Concept deepCopy() {
    return new TDbSync_Dsp_Campaign_Creative_Concept(this);
  }

  @Override
  public void clear() {
    setConceptIDIsSet(false);
    this.conceptID = 0;
    setStatusIsSet(false);
    this.status = 0;
    this.lastChanged = null;
    this.conceptName = null;
    setCampaignIDIsSet(false);
    this.campaignID = 0;
  }

  public int getConceptID() {
    return this.conceptID;
  }

  public TDbSync_Dsp_Campaign_Creative_Concept setConceptID(int conceptID) {
    this.conceptID = conceptID;
    setConceptIDIsSet(true);
    return this;
  }

  public void unsetConceptID() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __CONCEPTID_ISSET_ID);
  }

  /** Returns true if field conceptID is set (has been assigned a value) and false otherwise */
  public boolean isSetConceptID() {
    return EncodingUtils.testBit(__isset_bitfield, __CONCEPTID_ISSET_ID);
  }

  public void setConceptIDIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __CONCEPTID_ISSET_ID, value);
  }

  public int getStatus() {
    return this.status;
  }

  public TDbSync_Dsp_Campaign_Creative_Concept setStatus(int status) {
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

  public TDbSync_Dsp_Campaign_Creative_Concept setLastChanged(String lastChanged) {
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

  public String getConceptName() {
    return this.conceptName;
  }

  public TDbSync_Dsp_Campaign_Creative_Concept setConceptName(String conceptName) {
    this.conceptName = conceptName;
    return this;
  }

  public void unsetConceptName() {
    this.conceptName = null;
  }

  /** Returns true if field conceptName is set (has been assigned a value) and false otherwise */
  public boolean isSetConceptName() {
    return this.conceptName != null;
  }

  public void setConceptNameIsSet(boolean value) {
    if (!value) {
      this.conceptName = null;
    }
  }

  public int getCampaignID() {
    return this.campaignID;
  }

  public TDbSync_Dsp_Campaign_Creative_Concept setCampaignID(int campaignID) {
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

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case CONCEPT_ID:
      if (value == null) {
        unsetConceptID();
      } else {
        setConceptID((Integer)value);
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

    case CONCEPT_NAME:
      if (value == null) {
        unsetConceptName();
      } else {
        setConceptName((String)value);
      }
      break;

    case CAMPAIGN_ID:
      if (value == null) {
        unsetCampaignID();
      } else {
        setCampaignID((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case CONCEPT_ID:
      return Integer.valueOf(getConceptID());

    case STATUS:
      return Integer.valueOf(getStatus());

    case LAST_CHANGED:
      return getLastChanged();

    case CONCEPT_NAME:
      return getConceptName();

    case CAMPAIGN_ID:
      return Integer.valueOf(getCampaignID());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case CONCEPT_ID:
      return isSetConceptID();
    case STATUS:
      return isSetStatus();
    case LAST_CHANGED:
      return isSetLastChanged();
    case CONCEPT_NAME:
      return isSetConceptName();
    case CAMPAIGN_ID:
      return isSetCampaignID();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TDbSync_Dsp_Campaign_Creative_Concept)
      return this.equals((TDbSync_Dsp_Campaign_Creative_Concept)that);
    return false;
  }

  public boolean equals(TDbSync_Dsp_Campaign_Creative_Concept that) {
    if (that == null)
      return false;

    boolean this_present_conceptID = true;
    boolean that_present_conceptID = true;
    if (this_present_conceptID || that_present_conceptID) {
      if (!(this_present_conceptID && that_present_conceptID))
        return false;
      if (this.conceptID != that.conceptID)
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

    boolean this_present_conceptName = true && this.isSetConceptName();
    boolean that_present_conceptName = true && that.isSetConceptName();
    if (this_present_conceptName || that_present_conceptName) {
      if (!(this_present_conceptName && that_present_conceptName))
        return false;
      if (!this.conceptName.equals(that.conceptName))
        return false;
    }

    boolean this_present_campaignID = true;
    boolean that_present_campaignID = true;
    if (this_present_campaignID || that_present_campaignID) {
      if (!(this_present_campaignID && that_present_campaignID))
        return false;
      if (this.campaignID != that.campaignID)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(TDbSync_Dsp_Campaign_Creative_Concept other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetConceptID()).compareTo(other.isSetConceptID());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetConceptID()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.conceptID, other.conceptID);
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
    lastComparison = Boolean.valueOf(isSetConceptName()).compareTo(other.isSetConceptName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetConceptName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.conceptName, other.conceptName);
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
    StringBuilder sb = new StringBuilder("TDbSync_Dsp_Campaign_Creative_Concept(");
    boolean first = true;

    sb.append("conceptID:");
    sb.append(this.conceptID);
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
    sb.append("conceptName:");
    if (this.conceptName == null) {
      sb.append("null");
    } else {
      sb.append(this.conceptName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("campaignID:");
    sb.append(this.campaignID);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'conceptID' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'status' because it's a primitive and you chose the non-beans generator.
    if (lastChanged == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'lastChanged' was not present! Struct: " + toString());
    }
    if (conceptName == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'conceptName' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'campaignID' because it's a primitive and you chose the non-beans generator.
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

  private static class TDbSync_Dsp_Campaign_Creative_ConceptStandardSchemeFactory implements SchemeFactory {
    public TDbSync_Dsp_Campaign_Creative_ConceptStandardScheme getScheme() {
      return new TDbSync_Dsp_Campaign_Creative_ConceptStandardScheme();
    }
  }

  private static class TDbSync_Dsp_Campaign_Creative_ConceptStandardScheme extends StandardScheme<TDbSync_Dsp_Campaign_Creative_Concept> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TDbSync_Dsp_Campaign_Creative_Concept struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // CONCEPT_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.conceptID = iprot.readI32();
              struct.setConceptIDIsSet(true);
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
          case 4: // CONCEPT_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.conceptName = iprot.readString();
              struct.setConceptNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // CAMPAIGN_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.campaignID = iprot.readI32();
              struct.setCampaignIDIsSet(true);
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
      if (!struct.isSetConceptID()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'conceptID' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetStatus()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'status' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetCampaignID()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'campaignID' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, TDbSync_Dsp_Campaign_Creative_Concept struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(CONCEPT_ID_FIELD_DESC);
      oprot.writeI32(struct.conceptID);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(STATUS_FIELD_DESC);
      oprot.writeI32(struct.status);
      oprot.writeFieldEnd();
      if (struct.lastChanged != null) {
        oprot.writeFieldBegin(LAST_CHANGED_FIELD_DESC);
        oprot.writeString(struct.lastChanged);
        oprot.writeFieldEnd();
      }
      if (struct.conceptName != null) {
        oprot.writeFieldBegin(CONCEPT_NAME_FIELD_DESC);
        oprot.writeString(struct.conceptName);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(CAMPAIGN_ID_FIELD_DESC);
      oprot.writeI32(struct.campaignID);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TDbSync_Dsp_Campaign_Creative_ConceptTupleSchemeFactory implements SchemeFactory {
    public TDbSync_Dsp_Campaign_Creative_ConceptTupleScheme getScheme() {
      return new TDbSync_Dsp_Campaign_Creative_ConceptTupleScheme();
    }
  }

  private static class TDbSync_Dsp_Campaign_Creative_ConceptTupleScheme extends TupleScheme<TDbSync_Dsp_Campaign_Creative_Concept> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TDbSync_Dsp_Campaign_Creative_Concept struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.conceptID);
      oprot.writeI32(struct.status);
      oprot.writeString(struct.lastChanged);
      oprot.writeString(struct.conceptName);
      oprot.writeI32(struct.campaignID);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TDbSync_Dsp_Campaign_Creative_Concept struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.conceptID = iprot.readI32();
      struct.setConceptIDIsSet(true);
      struct.status = iprot.readI32();
      struct.setStatusIsSet(true);
      struct.lastChanged = iprot.readString();
      struct.setLastChangedIsSet(true);
      struct.conceptName = iprot.readString();
      struct.setConceptNameIsSet(true);
      struct.campaignID = iprot.readI32();
      struct.setCampaignIDIsSet(true);
    }
  }

}

