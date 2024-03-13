import {Button, Input, Radio, Select, Label} from './FormFields';
import React, { useEffect, useState } from 'react'
import { useNavigate } from "react-router-dom";

export default function FuelQuote ( {loggedInID} ) {
    
  const navigate = useNavigate();

    const retrievedAddress = '333 Fake Address Avenue'
    const retrievedRate = 3.55
    const calculatedTotal = 100;

    const [errors, setErrors] = useState({})
    const [errorClass, setErrorClass] = useState({})
    const [showTotal, setShowTotal] = useState(false);
    const [formData, setFormData] = useState({
        gallons: 0,
        address: '',
        date: '',
        rate: '',
        total: 0
    })

    const handleChange = (e) => {
        const {name, value} = e.target

        errors[name] = '';
        errorClass[name] = '';

        setFormData({
            ...formData, [name] : value
        })
    }

    const handleSubmit = (e) => {
        e.preventDefault()
        const validationErrors = {}
        const validationErrorClass = {}

        if(!formData.gallons){
            validationErrors.gallons = 'ERROR: required'
            validationErrorClass.gallons = 'error';
        }
        else if(formData.gallons == 0){
            validationErrors.gallons = 'ERROR: must be non-zero'
            validationErrorClass.gallons = 'error';
        }
        else if(formData.gallons <= 0){
            validationErrors.gallons = 'ERROR: must be positive'
            validationErrorClass.gallons = 'error';
        }

        if(!formData.date){
            validationErrors.date = 'ERROR: required'
            validationErrorClass.date = 'error';
        }
        setErrors(validationErrors);
        setErrorClass(validationErrorClass);

        if(Object.keys(validationErrors).length === 0){
          setShowTotal(true);
        }
    }

    useEffect(() => {
        if(!loggedInID) {
            navigate('/')
        }
      }, []);

    return (
        <>
        <form onSubmit={handleSubmit}>

        <Input name='gallons' label='Gallons: *' type='number' className={errorClass.gallons} handleChange={handleChange}></Input>
        {errors.gallons && <span class='error'>{errors.gallons}</span>}

        <Label name='address' label='Address:'></Label>

        <span className="filledData" name='address'>{retrievedAddress}</span>

        <Input name='date' label='Delivery Date: *' type='date' className={errorClass.date} handleChange={handleChange}></Input>
        {errors.date && <span class='error'>{errors.date}</span>}

        <Label name='rate' label='Suggested Price / Gallon:'></Label>
        <span className="filledData" name='rate'>{retrievedRate}</span>

        
        {showTotal ? 
          <>
          <Label name='total' label='Ammount Due:'></Label>
          <span className="filledData">${calculatedTotal}</span>
          </> :
          <Button name='submitButton' type='submit' buttonText='Get Quote'></Button>
        }
        
        </form>
        </>
    )
}