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

public class TDbSync_Dsp_Interactive_Message implements org.apache.thrift.TBase<TDbSync_Dsp_Interactive_Message, TDbSync_Dsp_Interactive_Message._Fields>, java.io.Serializable, Cloneable, Comparable<TDbSync_Dsp_Interactive_Message> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TDbSync_Dsp_Interactive_Message");

  private static final org.apache.thrift.protocol.TField MESSAGE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("messageID", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("status", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField LAST_CHANGED_FIELD_DESC = new org.apache.thrift.protocol.TField("lastChanged", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField MESSAGE_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("messageName", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField PAGE_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("pageType", org.apache.thrift.protocol.TType.I32, (short)5);
  private static final org.apache.thrift.protocol.TField NOTE_FIELD_DESC = new org.apache.thrift.protocol.TField("note", org.apache.thrift.protocol.TType.STRING, (short)6);
  private static final org.apache.thrift.protocol.TField VALUE_FIELD_DESC = new org.apache.thrift.protocol.TField("value", org.apache.thrift.protocol.TType.STRING, (short)7);
  private static final org.apache.thrift.protocol.TField CAMPAIGN_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("campaignID", org.apache.thrift.protocol.TType.I32, (short)8);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TDbSync_Dsp_Interactive_MessageStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TDbSync_Dsp_Interactive_MessageTupleSchemeFactory());
  }

  public int messageID; // required
  public int status; // required
  public String lastChanged; // required
  public String messageName; // required
  public int pageType; // required
  public String note; // required
  public String value; // required
  public int campaignID; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    MESSAGE_ID((short)1, "messageID"),
    STATUS((short)2, "status"),
    LAST_CHANGED((short)3, "lastChanged"),
    MESSAGE_NAME((short)4, "messageName"),
    PAGE_TYPE((short)5, "pageType"),
    NOTE((short)6, "note"),
    VALUE((short)7, "value"),
    CAMPAIGN_ID((short)8, "campaignID");

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
        case 1: // MESSAGE_ID
          return MESSAGE_ID;
        case 2: // STATUS
          return STATUS;
        case 3: // LAST_CHANGED
          return LAST_CHANGED;
        case 4: // MESSAGE_NAME
          return MESSAGE_NAME;
        case 5: // PAGE_TYPE
          return PAGE_TYPE;
        case 6: // NOTE
          return NOTE;
        case 7: // VALUE
          return VALUE;
        case 8: // CAMPAIGN_ID
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
  private static final int __MESSAGEID_ISSET_ID = 0;
  private static final int __STATUS_ISSET_ID = 1;
  private static final int __PAGETYPE_ISSET_ID = 2;
  private static final int __CAMPAIGNID_ISSET_ID = 3;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.MESSAGE_ID, new org.apache.thrift.meta_data.FieldMetaData("messageID", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.STATUS, new org.apache.thrift.meta_data.FieldMetaData("status", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.LAST_CHANGED, new org.apache.thrift.meta_data.FieldMetaData("lastChanged", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.MESSAGE_NAME, new org.apache.thrift.meta_data.FieldMetaData("messageName", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PAGE_TYPE, new org.apache.thrift.meta_data.FieldMetaData("pageType", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.NOTE, new org.apache.thrift.meta_data.FieldMetaData("note", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.VALUE, new org.apache.thrift.meta_data.FieldMetaData("value", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.CAMPAIGN_ID, new org.apache.thrift.meta_data.FieldMetaData("campaignID", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TDbSync_Dsp_Interactive_Message.class, metaDataMap);
  }

  public TDbSync_Dsp_Interactive_Message() {
  }

  public TDbSync_Dsp_Interactive_Message(
    int messageID,
    int status,
    String lastChanged,
    String messageName,
    int pageType,
    String note,
    String value,
    int campaignID)
  {
    this();
    this.messageID = messageID;
    setMessageIDIsSet(true);
    this.status = status;
    setStatusIsSet(true);
    this.lastChanged = lastChanged;
    this.messageName = messageName;
    this.pageType = pageType;
    setPageTypeIsSet(true);
    this.note = note;
    this.value = value;
    this.campaignID = campaignID;
    setCampaignIDIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TDbSync_Dsp_Interactive_Message(TDbSync_Dsp_Interactive_Message other) {
    __isset_bitfield = other.__isset_bitfield;
    this.messageID = other.messageID;
    this.status = other.status;
    if (other.isSetLastChanged()) {
      this.lastChanged = other.lastChanged;
    }
    if (other.isSetMessageName()) {
      this.messageName = other.messageName;
    }
    this.pageType = other.pageType;
    if (other.isSetNote()) {
      this.note = other.note;
    }
    if (other.isSetValue()) {
      this.value = other.value;
    }
    this.campaignID = other.campaignID;
  }

  public TDbSync_Dsp_Interactive_Message deepCopy() {
    return new TDbSync_Dsp_Interactive_Message(this);
  }

  @Override
  public void clear() {
    setMessageIDIsSet(false);
    this.messageID = 0;
    setStatusIsSet(false);
    this.status = 0;
    this.lastChanged = null;
    this.messageName = null;
    setPageTypeIsSet(false);
    this.pageType = 0;
    this.note = null;
    this.value = null;
    setCampaignIDIsSet(false);
    this.campaignID = 0;
  }

  public int getMessageID() {
    return this.messageID;
  }

  public TDbSync_Dsp_Interactive_Message setMessageID(int messageID) {
    this.messageID = messageID;
    setMessageIDIsSet(true);
    return this;
  }

  public void unsetMessageID() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __MESSAGEID_ISSET_ID);
  }

  /** Returns true if field messageID is set (has been assigned a value) and false otherwise */
  public boolean isSetMessageID() {
    return EncodingUtils.testBit(__isset_bitfield, __MESSAGEID_ISSET_ID);
  }

  public void setMessageIDIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __MESSAGEID_ISSET_ID, value);
  }

  public int getStatus() {
    return this.status;
  }

  public TDbSync_Dsp_Interactive_Message setStatus(int status) {
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

  public TDbSync_Dsp_Interactive_Message setLastChanged(String lastChanged) {
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

  public String getMessageName() {
    return this.messageName;
  }

  public TDbSync_Dsp_Interactive_Message setMessageName(String messageName) {
    this.messageName = messageName;
    return this;
  }

  public void unsetMessageName() {
    this.messageName = null;
  }

  /** Returns true if field messageName is set (has been assigned a value) and false otherwise */
  public boolean isSetMessageName() {
    return this.messageName != null;
  }

  public void setMessageNameIsSet(boolean value) {
    if (!value) {
      this.messageName = null;
    }
  }

  public int getPageType() {
    return this.pageType;
  }

  public TDbSync_Dsp_Interactive_Message setPageType(int pageType) {
    this.pageType = pageType;
    setPageTypeIsSet(true);
    return this;
  }

  public void unsetPageType() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __PAGETYPE_ISSET_ID);
  }

  /** Returns true if field pageType is set (has been assigned a value) and false otherwise */
  public boolean isSetPageType() {
    return EncodingUtils.testBit(__isset_bitfield, __PAGETYPE_ISSET_ID);
  }

  public void setPageTypeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __PAGETYPE_ISSET_ID, value);
  }

  public String getNote() {
    return this.note;
  }

  public TDbSync_Dsp_Interactive_Message setNote(String note) {
    this.note = note;
    return this;
  }

  public void unsetNote() {
    this.note = null;
  }

  /** Returns true if field note is set (has been assigned a value) and false otherwise */
  public boolean isSetNote() {
    return this.note != null;
  }

  public void setNoteIsSet(boolean value) {
    if (!value) {
      this.note = null;
    }
  }

  public String getValue() {
    return this.value;
  }

  public TDbSync_Dsp_Interactive_Message setValue(String value) {
    this.value = value;
    return this;
  }

  public void unsetValue() {
    this.value = null;
  }

  /** Returns true if field value is set (has been assigned a value) and false otherwise */
  public boolean isSetValue() {
    return this.value != null;
  }

  public void setValueIsSet(boolean value) {
    if (!value) {
      this.value = null;
    }
  }

  public int getCampaignID() {
    return this.campaignID;
  }

  public TDbSync_Dsp_Interactive_Message setCampaignID(int campaignID) {
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
    case MESSAGE_ID:
      if (value == null) {
        unsetMessageID();
      } else {
        setMessageID((Integer)value);
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

    case MESSAGE_NAME:
      if (value == null) {
        unsetMessageName();
      } else {
        setMessageName((String)value);
      }
      break;

    case PAGE_TYPE:
      if (value == null) {
        unsetPageType();
      } else {
        setPageType((Integer)value);
      }
      break;

    case NOTE:
      if (value == null) {
        unsetNote();
      } else {
        setNote((String)value);
      }
      break;

    case VALUE:
      if (value == null) {
        unsetValue();
      } else {
        setValue((String)value);
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
    case MESSAGE_ID:
      return Integer.valueOf(getMessageID());

    case STATUS:
      return Integer.valueOf(getStatus());

    case LAST_CHANGED:
      return getLastChanged();

    case MESSAGE_NAME:
      return getMessageName();

    case PAGE_TYPE:
      return Integer.valueOf(getPageType());

    case NOTE:
      return getNote();

    case VALUE:
      return getValue();

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
    case MESSAGE_ID:
      return isSetMessageID();
    case STATUS:
      return isSetStatus();
    case LAST_CHANGED:
      return isSetLastChanged();
    case MESSAGE_NAME:
      return isSetMessageName();
    case PAGE_TYPE:
      return isSetPageType();
    case NOTE:
      return isSetNote();
    case VALUE:
      return isSetValue();
    case CAMPAIGN_ID:
      return isSetCampaignID();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TDbSync_Dsp_Interactive_Message)
      return this.equals((TDbSync_Dsp_Interactive_Message)that);
    return false;
  }

  public boolean equals(TDbSync_Dsp_Interactive_Message that) {
    if (that == null)
      return false;

    boolean this_present_messageID = true;
    boolean that_present_messageID = true;
    if (this_present_messageID || that_present_messageID) {
      if (!(this_present_messageID && that_present_messageID))
        return false;
      if (this.messageID != that.messageID)
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

    boolean this_present_messageName = true && this.isSetMessageName();
    boolean that_present_messageName = true && that.isSetMessageName();
    if (this_present_messageName || that_present_messageName) {
      if (!(this_present_messageName && that_present_messageName))
        return false;
      if (!this.messageName.equals(that.messageName))
        return false;
    }

    boolean this_present_pageType = true;
    boolean that_present_pageType = true;
    if (this_present_pageType || that_present_pageType) {
      if (!(this_present_pageType && that_present_pageType))
        return false;
      if (this.pageType != that.pageType)
        return false;
    }

    boolean this_present_note = true && this.isSetNote();
    boolean that_present_note = true && that.isSetNote();
    if (this_present_note || that_present_note) {
      if (!(this_present_note && that_present_note))
        return false;
      if (!this.note.equals(that.note))
        return false;
    }

    boolean this_present_value = true && this.isSetValue();
    boolean that_present_value = true && that.isSetValue();
    if (this_present_value || that_present_value) {
      if (!(this_present_value && that_present_value))
        return false;
      if (!this.value.equals(that.value))
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
  public int compareTo(TDbSync_Dsp_Interactive_Message other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetMessageID()).compareTo(other.isSetMessageID());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMessageID()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.messageID, other.messageID);
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
    lastComparison = Boolean.valueOf(isSetMessageName()).compareTo(other.isSetMessageName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMessageName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.messageName, other.messageName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPageType()).compareTo(other.isSetPageType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPageType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.pageType, other.pageType);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetNote()).compareTo(other.isSetNote());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNote()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.note, other.note);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetValue()).compareTo(other.isSetValue());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetValue()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.value, other.value);
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
    StringBuilder sb = new StringBuilder("TDbSync_Dsp_Interactive_Message(");
    boolean first = true;

    sb.append("messageID:");
    sb.append(this.messageID);
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
    sb.append("messageName:");
    if (this.messageName == null) {
      sb.append("null");
    } else {
      sb.append(this.messageName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("pageType:");
    sb.append(this.pageType);
    first = false;
    if (!first) sb.append(", ");
    sb.append("note:");
    if (this.note == null) {
      sb.append("null");
    } else {
      sb.append(this.note);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("value:");
    if (this.value == null) {
      sb.append("null");
    } else {
      sb.append(this.value);
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
    // alas, we cannot check 'messageID' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'status' because it's a primitive and you chose the non-beans generator.
    if (lastChanged == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'lastChanged' was not present! Struct: " + toString());
    }
    if (messageName == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'messageName' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'pageType' because it's a primitive and you chose the non-beans generator.
    if (note == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'note' was not present! Struct: " + toString());
    }
    if (value == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'value' was not present! Struct: " + toString());
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

  private static class TDbSync_Dsp_Interactive_MessageStandardSchemeFactory implements SchemeFactory {
    public TDbSync_Dsp_Interactive_MessageStandardScheme getScheme() {
      return new TDbSync_Dsp_Interactive_MessageStandardScheme();
    }
  }

  private static class TDbSync_Dsp_Interactive_MessageStandardScheme extends StandardScheme<TDbSync_Dsp_Interactive_Message> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TDbSync_Dsp_Interactive_Message struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // MESSAGE_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.messageID = iprot.readI32();
              struct.setMessageIDIsSet(true);
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
          case 4: // MESSAGE_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.messageName = iprot.readString();
              struct.setMessageNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // PAGE_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.pageType = iprot.readI32();
              struct.setPageTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // NOTE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.note = iprot.readString();
              struct.setNoteIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // VALUE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.value = iprot.readString();
              struct.setValueIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 8: // CAMPAIGN_ID
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
      if (!struct.isSetMessageID()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'messageID' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetStatus()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'status' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetPageType()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'pageType' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetCampaignID()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'campaignID' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, TDbSync_Dsp_Interactive_Message struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(MESSAGE_ID_FIELD_DESC);
      oprot.writeI32(struct.messageID);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(STATUS_FIELD_DESC);
      oprot.writeI32(struct.status);
      oprot.writeFieldEnd();
      if (struct.lastChanged != null) {
        oprot.writeFieldBegin(LAST_CHANGED_FIELD_DESC);
        oprot.writeString(struct.lastChanged);
        oprot.writeFieldEnd();
      }
      if (struct.messageName != null) {
        oprot.writeFieldBegin(MESSAGE_NAME_FIELD_DESC);
        oprot.writeString(struct.messageName);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(PAGE_TYPE_FIELD_DESC);
      oprot.writeI32(struct.pageType);
      oprot.writeFieldEnd();
      if (struct.note != null) {
        oprot.writeFieldBegin(NOTE_FIELD_DESC);
        oprot.writeString(struct.note);
        oprot.writeFieldEnd();
      }
      if (struct.value != null) {
        oprot.writeFieldBegin(VALUE_FIELD_DESC);
        oprot.writeString(struct.value);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(CAMPAIGN_ID_FIELD_DESC);
      oprot.writeI32(struct.campaignID);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TDbSync_Dsp_Interactive_MessageTupleSchemeFactory implements SchemeFactory {
    public TDbSync_Dsp_Interactive_MessageTupleScheme getScheme() {
      return new TDbSync_Dsp_Interactive_MessageTupleScheme();
    }
  }

  private static class TDbSync_Dsp_Interactive_MessageTupleScheme extends TupleScheme<TDbSync_Dsp_Interactive_Message> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TDbSync_Dsp_Interactive_Message struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.messageID);
      oprot.writeI32(struct.status);
      oprot.writeString(struct.lastChanged);
      oprot.writeString(struct.messageName);
      oprot.writeI32(struct.pageType);
      oprot.writeString(struct.note);
      oprot.writeString(struct.value);
      oprot.writeI32(struct.campaignID);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TDbSync_Dsp_Interactive_Message struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.messageID = iprot.readI32();
      struct.setMessageIDIsSet(true);
      struct.status = iprot.readI32();
      struct.setStatusIsSet(true);
      struct.lastChanged = iprot.readString();
      struct.setLastChangedIsSet(true);
      struct.messageName = iprot.readString();
      struct.setMessageNameIsSet(true);
      struct.pageType = iprot.readI32();
      struct.setPageTypeIsSet(true);
      struct.note = iprot.readString();
      struct.setNoteIsSet(true);
      struct.value = iprot.readString();
      struct.setValueIsSet(true);
      struct.campaignID = iprot.readI32();
      struct.setCampaignIDIsSet(true);
    }
  }

}

