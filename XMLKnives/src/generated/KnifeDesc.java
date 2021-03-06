//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.02.05 at 09:40:32 AM EST 
//


package generated;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for knifeDesc complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="knifeDesc">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="knifeType">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="knife"/>
 *               &lt;enumeration value="dagger"/>
 *               &lt;enumeration value="saber"/>
 *               &lt;enumeration value="sword"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="handy">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *               &lt;minInclusive value="1"/>
 *               &lt;maxInclusive value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="origin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="visual">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="blade">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="length" use="required" type="{}bladeSize" />
 *                           &lt;attribute name="width" use="required" type="{}bladeSize" />
 *                           &lt;attribute name="metal" use="required" type="{}metalType" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="handle">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;choice>
 *                             &lt;element name="wood">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;attribute name="type" use="required" type="{}woodType" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="metal" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                             &lt;element name="plastic" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                           &lt;/choice>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="dol" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="collection" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "knifeDesc", propOrder = {
    "knifeType",
    "handy",
    "origin",
    "visual",
    "collection"
})
public class KnifeDesc {

    @XmlElement(required = true)
    protected String knifeType;
    protected int handy;
    @XmlElement(required = true)
    protected String origin;
    @XmlElement(required = true)
    protected KnifeDesc.Visual visual;
    protected boolean collection;
    @XmlAttribute(name = "name")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String name;

    /**
     * Gets the value of the knifeType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKnifeType() {
        return knifeType;
    }

    /**
     * Sets the value of the knifeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKnifeType(String value) {
        this.knifeType = value;
    }

    /**
     * Gets the value of the handy property.
     * 
     */
    public int getHandy() {
        return handy;
    }

    /**
     * Sets the value of the handy property.
     * 
     */
    public void setHandy(int value) {
        this.handy = value;
    }

    /**
     * Gets the value of the origin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Sets the value of the origin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrigin(String value) {
        this.origin = value;
    }

    /**
     * Gets the value of the visual property.
     * 
     * @return
     *     possible object is
     *     {@link KnifeDesc.Visual }
     *     
     */
    public KnifeDesc.Visual getVisual() {
        return visual;
    }

    /**
     * Sets the value of the visual property.
     * 
     * @param value
     *     allowed object is
     *     {@link KnifeDesc.Visual }
     *     
     */
    public void setVisual(KnifeDesc.Visual value) {
        this.visual = value;
    }

    /**
     * Gets the value of the collection property.
     * 
     */
    public boolean isCollection() {
        return collection;
    }

    /**
     * Sets the value of the collection property.
     * 
     */
    public void setCollection(boolean value) {
        this.collection = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="blade">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="length" use="required" type="{}bladeSize" />
     *                 &lt;attribute name="width" use="required" type="{}bladeSize" />
     *                 &lt;attribute name="metal" use="required" type="{}metalType" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="handle">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;choice>
     *                   &lt;element name="wood">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;attribute name="type" use="required" type="{}woodType" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="metal" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
     *                   &lt;element name="plastic" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
     *                 &lt;/choice>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="dol" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "blade",
        "handle",
        "dol"
    })
    public static class Visual {

        @XmlElement(required = true)
        protected KnifeDesc.Visual.Blade blade;
        @XmlElement(required = true)
        protected KnifeDesc.Visual.Handle handle;
        protected boolean dol;

        /**
         * Gets the value of the blade property.
         * 
         * @return
         *     possible object is
         *     {@link KnifeDesc.Visual.Blade }
         *     
         */
        public KnifeDesc.Visual.Blade getBlade() {
            return blade;
        }

        /**
         * Sets the value of the blade property.
         * 
         * @param value
         *     allowed object is
         *     {@link KnifeDesc.Visual.Blade }
         *     
         */
        public void setBlade(KnifeDesc.Visual.Blade value) {
            this.blade = value;
        }

        /**
         * Gets the value of the handle property.
         * 
         * @return
         *     possible object is
         *     {@link KnifeDesc.Visual.Handle }
         *     
         */
        public KnifeDesc.Visual.Handle getHandle() {
            return handle;
        }

        /**
         * Sets the value of the handle property.
         * 
         * @param value
         *     allowed object is
         *     {@link KnifeDesc.Visual.Handle }
         *     
         */
        public void setHandle(KnifeDesc.Visual.Handle value) {
            this.handle = value;
        }

        /**
         * Gets the value of the dol property.
         * 
         */
        public boolean isDol() {
            return dol;
        }

        /**
         * Sets the value of the dol property.
         * 
         */
        public void setDol(boolean value) {
            this.dol = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;attribute name="length" use="required" type="{}bladeSize" />
         *       &lt;attribute name="width" use="required" type="{}bladeSize" />
         *       &lt;attribute name="metal" use="required" type="{}metalType" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Blade {

            @XmlAttribute(name = "length", required = true)
            protected BigInteger length;
            @XmlAttribute(name = "width", required = true)
            protected BigInteger width;
            @XmlAttribute(name = "metal", required = true)
            protected MetalType metal;

            /**
             * Gets the value of the length property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getLength() {
                return length;
            }

            /**
             * Sets the value of the length property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setLength(BigInteger value) {
                this.length = value;
            }

            /**
             * Gets the value of the width property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getWidth() {
                return width;
            }

            /**
             * Sets the value of the width property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setWidth(BigInteger value) {
                this.width = value;
            }

            /**
             * Gets the value of the metal property.
             * 
             * @return
             *     possible object is
             *     {@link MetalType }
             *     
             */
            public MetalType getMetal() {
                return metal;
            }

            /**
             * Sets the value of the metal property.
             * 
             * @param value
             *     allowed object is
             *     {@link MetalType }
             *     
             */
            public void setMetal(MetalType value) {
                this.metal = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;choice>
         *         &lt;element name="wood">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;attribute name="type" use="required" type="{}woodType" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="metal" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
         *         &lt;element name="plastic" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
         *       &lt;/choice>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "wood",
            "metal",
            "plastic"
        })
        public static class Handle {

            protected KnifeDesc.Visual.Handle.Wood wood;
            protected Object metal;
            protected Object plastic;

            /**
             * Gets the value of the wood property.
             * 
             * @return
             *     possible object is
             *     {@link KnifeDesc.Visual.Handle.Wood }
             *     
             */
            public KnifeDesc.Visual.Handle.Wood getWood() {
                return wood;
            }

            /**
             * Sets the value of the wood property.
             * 
             * @param value
             *     allowed object is
             *     {@link KnifeDesc.Visual.Handle.Wood }
             *     
             */
            public void setWood(KnifeDesc.Visual.Handle.Wood value) {
                this.wood = value;
            }

            /**
             * Gets the value of the metal property.
             * 
             * @return
             *     possible object is
             *     {@link Object }
             *     
             */
            public Object getMetal() {
                return metal;
            }

            /**
             * Sets the value of the metal property.
             * 
             * @param value
             *     allowed object is
             *     {@link Object }
             *     
             */
            public void setMetal(Object value) {
                this.metal = value;
            }

            /**
             * Gets the value of the plastic property.
             * 
             * @return
             *     possible object is
             *     {@link Object }
             *     
             */
            public Object getPlastic() {
                return plastic;
            }

            /**
             * Sets the value of the plastic property.
             * 
             * @param value
             *     allowed object is
             *     {@link Object }
             *     
             */
            public void setPlastic(Object value) {
                this.plastic = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;attribute name="type" use="required" type="{}woodType" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class Wood {

                @XmlAttribute(name = "type", required = true)
                protected WoodType type;

                /**
                 * Gets the value of the type property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link WoodType }
                 *     
                 */
                public WoodType getType() {
                    return type;
                }

                /**
                 * Sets the value of the type property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link WoodType }
                 *     
                 */
                public void setType(WoodType value) {
                    this.type = value;
                }

            }

        }

    }

}
