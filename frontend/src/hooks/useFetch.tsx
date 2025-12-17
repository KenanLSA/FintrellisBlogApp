import axios, { AxiosError } from "axios";
import { useEffect, useState } from "react";

export function useFetch<T>(url: string) {
    const [data, setData] = useState<T>();
    const [error, setError] = useState<AxiosError>();

    useEffect(() => {
        async function getData() {
            await axios.get(url)
                .then(res => setData(res.data))
                .catch(err => { setError(err)})
        }

        getData();
        
    }, [])

    return {data, error};
}