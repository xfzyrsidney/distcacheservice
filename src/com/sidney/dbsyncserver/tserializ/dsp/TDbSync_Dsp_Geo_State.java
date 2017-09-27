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

public class TDbSync_Dsp_Geo_State implements org.apache.thrift.TBase<TDbSync_Dsp_Geo_State, TDbSync_Dsp_Geo_State._Fields>, java.io.Serializable, Cloneable, Comparable<TDbSync_Dsp_Geo_State> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TDbSync_Dsp_Geo_State");

  private static final org.apache.thrift.protocol.TField I_D_FIELD_DESC = new org.apache.thrift.protocol.TField("iD", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("status", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField LAST_CHANGED_FIELD_DESC = new org.apache.thrift.protocol.TField("lastChanged", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("name", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField COUNTRY_FIELD_DESC = new org.apache.thrift.protocol.TField("country", org.apache.thrift.protocol.TType.I32, (short)5);
  private static final org.apache.thrift.protocol.TField AREA_FIELD_DESC = new org.apache.thrift.protocol.TField("area", org.apache.thrift.protocol.TType.I32, (short)6);
  private static final org.apache.thrift.protocol.TField FULL_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("fullName", org.apache.thrift.protocol.TType.STRING, (short)7);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TDbSync_Dsp_Geo_StateStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TDbSync_Dsp_Geo_StateTupleSchemeFactory());
  }

  public int iD; // required
  public int status; // required
  public String lastChanged; // required
  public String name; // required
  public int country; // required
  public int area; // required
  public String fullName; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    I_D((short)1, "iD"),
    STATUS((short)2, "status"),
    LAST_CHANGED((short)3, "lastChanged"),
    NAME((short)4, "name"),
    COUNTRY((short)5, "country"),
    AREA((short)6, "area"),
    FULL_NAME((short)7, "fullName");

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
        case 1: // I_D
          return I_D;
        case 2: // STATUS
          return STATUS;
        case 3: // LAST_CHANGED
          return LAST_CHANGED;
        case 4: // NAME
          return NAME;
        case 5: // COUNTRY
          return COUNTRY;
        case 6: // AREA
          return AREA;
        case 7: // FULL_NAME
          return FULL_NAME;
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
  private static final int __ID_ISSET_ID = 0;
  private static final int __STATUS_ISSET_ID = 1;
  private static final int __COUNTRY_ISSET_ID = 2;
  private static final int __AREA_ISSET_ID = 3;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.I_D, new org.apache.thrift.meta_data.FieldMetaData("iD", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.STATUS, new org.apache.thrift.meta_data.FieldMetaData("status", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.LAST_CHANGED, new org.apache.thrift.meta_data.FieldMetaData("lastChanged", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.NAME, new org.apache.thrift.meta_data.FieldMetaData("name", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.COUNTRY, new org.apache.thrift.meta_data.FieldMetaData("country", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.AREA, new org.apache.thrift.meta_data.FieldMetaData("area", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.FULL_NAME, new org.apache.thrift.meta_data.FieldMetaData("fullName", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TDbSync_Dsp_Geo_State.class, metaDataMap);
  }

  public TDbSync_Dsp_Geo_State() {
  }

  public TDbSync_Dsp_Geo_State(
    int iD,
    int status,
    String lastChanged,
    String name,
    int country,
    int area,
    String fullName)
  {
    this();
    this.iD = iD;
    setIDIsSet(true);
    this.status = status;
    setStatusIsSet(true);
    this.lastChanged = lastChanged;
    this.name = name;
    this.country = country;
    setCountryIsSet(true);
    this.area = area;
    setAreaIsSet(true);
    this.fullName = fullName;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TDbSync_Dsp_Geo_State(TDbSync_Dsp_Geo_State other) {
    __isset_bitfield = other.__isset_bitfield;
    this.iD = other.iD;
    this.status = other.status;
    if (other.isSetLastChanged()) {
      this.lastChanged = other.lastChanged;
    }
    if (other.isSetName()) {
      this.name = other.name;
    }
    this.country = other.country;
    this.area = other.area;
    if (other.isSetFullName()) {
      this.fullName = other.fullName;
    }
  }

  public TDbSync_Dsp_Geo_State deepCopy() {
    return new TDbSync_Dsp_Geo_State(this);
  }

  @Override
  public void clear() {
    setIDIsSet(false);
    this.iD = 0;
    setStatusIsSet(false);
    this.status = 0;
    this.lastChanged = null;
    this.name = null;
    setCountryIsSet(false);
    this.country = 0;
    setAreaIsSet(false);
    this.area = 0;
    this.fullName = null;
  }

  public int getID() {
    return this.iD;
  }

  public TDbSync_Dsp_Geo_State setID(int iD) {
    this.iD = iD;
    setIDIsSet(true);
    return this;
  }

  public void unsetID() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ID_ISSET_ID);
  }

  /** Returns true if field iD is set (has been assigned a value) and false otherwise */
  public boolean isSetID() {
    return EncodingUtils.testBit(__isset_bitfield, __ID_ISSET_ID);
  }

  public void setIDIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ID_ISSET_ID, value);
  }

  public int getStatus() {
    return this.status;
  }

  public TDbSync_Dsp_Geo_State setStatus(int status) {
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

  public TDbSync_Dsp_Geo_State setLastChanged(String lastChanged) {
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

  public String getName() {
    return this.name;
  }

  public TDbSync_Dsp_Geo_State setName(String name) {
    this.name = name;
    return this;
  }

  public void unsetName() {
    this.name = null;
  }

  /** Returns true if field name is set (has been assigned a value) and false otherwise */
  public boolean isSetName() {
    return this.name != null;
  }

  public void setNameIsSet(boolean value) {
    if (!value) {
      this.name = null;
    }
  }

  public int getCountry() {
    return this.country;
  }

  public TDbSync_Dsp_Geo_State setCountry(int country) {
    this.country = country;
    setCountryIsSet(true);
    return this;
  }

  public void unsetCountry() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __COUNTRY_ISSET_ID);
  }

  /** Returns true if field country is set (has been assigned a value) and false otherwise */
  public boolean isSetCountry() {
    return EncodingUtils.testBit(__isset_bitfield, __COUNTRY_ISSET_ID);
  }

  public void setCountryIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __COUNTRY_ISSET_ID, value);
  }

  public int getArea() {
    return this.area;
  }

  public TDbSync_Dsp_Geo_State setArea(int area) {
    this.area = area;
    setAreaIsSet(true);
    return this;
  }

  public void unsetArea() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __AREA_ISSET_ID);
  }

  /** Returns true if field area is set (has been assigned a value) and false otherwise */
  public boolean isSetArea() {
    return EncodingUtils.testBit(__isset_bitfield, __AREA_ISSET_ID);
  }

  public void setAreaIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __AREA_ISSET_ID, value);
  }

  public String getFullName() {
    return this.fullName;
  }

  public TDbSync_Dsp_Geo_State setFullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  public void unsetFullName() {
    this.fullName = null;
  }

  /** Returns true if field fullName is set (has been assigned a value) and false otherwise */
  public boolean isSetFullName() {
    return this.fullName != null;
  }

  public void setFullNameIsSet(boolean value) {
    if (!value) {
      this.fullName = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case I_D:
      if (value == null) {
        unsetID();
      } else {
        setID((Integer)value);
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

    case NAME:
      if (value == null) {
        unsetName();
      } else {
        setName((String)value);
      }
      break;

    case COUNTRY:
      if (value == null) {
        unsetCountry();
      } else {
        setCountry((Integer)value);
      }
      break;

    case AREA:
      if (value == null) {
        unsetArea();
      } else {
        setArea((Integer)value);
      }
      break;

    case FULL_NAME:
      if (value == null) {
        unsetFullName();
      } else {
        setFullName((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case I_D:
      return Integer.valueOf(getID());

    case STATUS:
      return Integer.valueOf(getStatus());

    case LAST_CHANGED:
      return getLastChanged();

    case NAME:
      return getName();

    case COUNTRY:
      return Integer.valueOf(getCountry());

    case AREA:
      return Integer.valueOf(getArea());

    case FULL_NAME:
      return getFullName();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case I_D:
      return isSetID();
    case STATUS:
      return isSetStatus();
    case LAST_CHANGED:
      return isSetLastChanged();
    case NAME:
      return isSetName();
    case COUNTRY:
      return isSetCountry();
    case AREA:
      return isSetArea();
    case FULL_NAME:
      return isSetFullName();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TDbSync_Dsp_Geo_State)
      return this.equals((TDbSync_Dsp_Geo_State)that);
    return false;
  }

  public boolean equals(TDbSync_Dsp_Geo_State that) {
    if (that == null)
      return false;

    boolean this_present_iD = true;
    boolean that_present_iD = true;
    if (this_present_iD || that_present_iD) {
      if (!(this_present_iD && that_present_iD))
        return false;
      if (this.iD != that.iD)
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

    boolean this_present_name = true && this.isSetName();
    boolean that_present_name = true && that.isSetName();
    if (this_present_name || that_present_name) {
      if (!(this_present_name && that_present_name))
        return false;
      if (!this.name.equals(that.name))
        return false;
    }

    boolean this_present_country = true;
    boolean that_present_country = true;
    if (this_present_country || that_present_country) {
      if (!(this_present_country && that_present_country))
        return false;
      if (this.country != that.country)
        return false;
    }

    boolean this_present_area = true;
    boolean that_present_area = true;
    if (this_present_area || that_present_area) {
      if (!(this_present_area && that_present_area))
        return false;
      if (this.area != that.area)
        return false;
    }

    boolean this_present_fullName = true && this.isSetFullName();
    boolean that_present_fullName = true && that.isSetFullName();
    if (this_present_fullName || that_present_fullName) {
      if (!(this_present_fullName && that_present_fullName))
        return false;
      if (!this.fullName.equals(that.fullName))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(TDbSync_Dsp_Geo_State other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetID()).compareTo(other.isSetID());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetID()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.iD, other.iD);
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
    lastComparison = Boolean.valueOf(isSetName()).compareTo(other.isSetName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.name, other.name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCountry()).compareTo(other.isSetCountry());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCountry()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.country, other.country);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetArea()).compareTo(other.isSetArea());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetArea()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.area, other.area);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFullName()).compareTo(other.isSetFullName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFullName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.fullName, other.fullName);
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
    StringBuilder sb = new StringBuilder("TDbSync_Dsp_Geo_State(");
    boolean first = true;

    sb.append("iD:");
    sb.append(this.iD);
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
    sb.append("name:");
    if (this.name == null) {
      sb.append("null");
    } else {
      sb.append(this.name);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("country:");
    sb.append(this.country);
    first = false;
    if (!first) sb.append(", ");
    sb.append("area:");
    sb.append(this.area);
    first = false;
    if (!first) sb.append(", ");
    sb.append("fullName:");
    if (this.fullName == null) {
      sb.append("null");
    } else {
      sb.append(this.fullName);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'iD' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'status' because it's a primitive and you chose the non-beans generator.
    if (lastChanged == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'lastChanged' was not present! Struct: " + toString());
    }
    if (name == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'name' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'country' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'area' because it's a primitive and you chose the non-beans generator.
    if (fullName == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'fullName' was not present! Struct: " + toString());
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

  private static class TDbSync_Dsp_Geo_StateStandardSchemeFactory implements SchemeFactory {
    public TDbSync_Dsp_Geo_StateStandardScheme getScheme() {
      return new TDbSync_Dsp_Geo_StateStandardScheme();
    }
  }

  private static class TDbSync_Dsp_Geo_StateStandardScheme extends StandardScheme<TDbSync_Dsp_Geo_State> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TDbSync_Dsp_Geo_State struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // I_D
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.iD = iprot.readI32();
              struct.setIDIsSet(true);
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
          case 4: // NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.name = iprot.readString();
              struct.setNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // COUNTRY
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.country = iprot.readI32();
              struct.setCountryIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // AREA
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.area = iprot.readI32();
              struct.setAreaIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // FULL_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.fullName = iprot.readString();
              struct.setFullNameIsSet(true);
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
      if (!struct.isSetID()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'iD' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetStatus()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'status' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetCountry()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'country' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetArea()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'area' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, TDbSync_Dsp_Geo_State struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(I_D_FIELD_DESC);
      oprot.writeI32(struct.iD);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(STATUS_FIELD_DESC);
      oprot.writeI32(struct.status);
      oprot.writeFieldEnd();
      if (struct.lastChanged != null) {
        oprot.writeFieldBegin(LAST_CHANGED_FIELD_DESC);
        oprot.writeString(struct.lastChanged);
        oprot.writeFieldEnd();
      }
      if (struct.name != null) {
        oprot.writeFieldBegin(NAME_FIELD_DESC);
        oprot.writeString(struct.name);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(COUNTRY_FIELD_DESC);
      oprot.writeI32(struct.country);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(AREA_FIELD_DESC);
      oprot.writeI32(struct.area);
      oprot.writeFieldEnd();
      if (struct.fullName != null) {
        oprot.writeFieldBegin(FULL_NAME_FIELD_DESC);
        oprot.writeString(struct.fullName);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TDbSync_Dsp_Geo_StateTupleSchemeFactory implements SchemeFactory {
    public TDbSync_Dsp_Geo_StateTupleScheme getScheme() {
      return new TDbSync_Dsp_Geo_StateTupleScheme();
    }
  }

  private static class TDbSync_Dsp_Geo_StateTupleScheme extends TupleScheme<TDbSync_Dsp_Geo_State> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TDbSync_Dsp_Geo_State struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.iD);
      oprot.writeI32(struct.status);
      oprot.writeString(struct.lastChanged);
      oprot.writeString(struct.name);
      oprot.writeI32(struct.country);
      oprot.writeI32(struct.area);
      oprot.writeString(struct.fullName);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TDbSync_Dsp_Geo_State struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.iD = iprot.readI32();
      struct.setIDIsSet(true);
      struct.status = iprot.readI32();
      struct.setStatusIsSet(true);
      struct.lastChanged = iprot.readString();
      struct.setLastChangedIsSet(true);
      struct.name = iprot.readString();
      struct.setNameIsSet(true);
      struct.country = iprot.readI32();
      struct.setCountryIsSet(true);
      struct.area = iprot.readI32();
      struct.setAreaIsSet(true);
      struct.fullName = iprot.readString();
      struct.setFullNameIsSet(true);
    }
  }

}
