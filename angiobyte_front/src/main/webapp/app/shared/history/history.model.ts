export class History {
    public historial?: number;
    public nombre?: string;
    public visita?: number;
    public direccion?: string;
    public fechanac?: Date;
    public fecha?: Date;
    public notas?: string;
    public ciudad?: string;
    public procedencia?: string;
    public profesion?: string;
    public antecedentes?: string;
    public i5?: string;
    public i6?: string;
    public i7?: string;
    public i8?: string;
    public i9?: string;
    public i10?: string;
    public i11?: string;
    public i12?: string;
    public i13?: string;
    public i14?: string;
    public i15?: string;
    public i16?: string;
    public imaginet?: number;
    public nuhsa?: string;

    constructor(
        historial?: number,
        nombre?: string,
        visita?: number,
        direccion?: string,
        fechanac?: Date,
        fecha?: Date,
        notas?: string,
        ciudad?: string,
        procedencia?: string,
        profesion?: string,
        antecedentes?: string,
        i5?: string,
        i6?: string,
        i7?: string,
        i8?: string,
        i9?: string,
        i10?: string,
        i11?: string,
        i12?: string,
        i13?: string,
        i14?: string,
        i15?: string,
        i16?: string,
        imaginet?: number,
        nuhsa?: string
    ) {
        this.historial = historial ? historial : null;
        this.nombre = nombre ? nombre : null;
        this.visita = visita ? visita : null;
        this.direccion = direccion ? direccion : null;
        this.fechanac = fechanac ? fechanac : null;
        this.fecha = fecha ? fecha : null;
        this.notas = notas ? notas : null;
        this.ciudad = ciudad ? ciudad : null;
        this.procedencia = procedencia ? procedencia : null;
        this.profesion = profesion ? profesion : null;
        this.antecedentes = antecedentes ? antecedentes : null;
        this.i5 = i5 ? i5 : null;
        this.i6 = i6 ? i6 : null;
        this.i7 = i7 ? i7 : null;
        this.i8 = i8 ? i8 : null;
        this.i9 = i9 ? i9 : null;
        this.i10 = i10 ? i10 : null;
        this.i11 = i11 ? i11 : null;
        this.i12 = i12 ? i12 : null;
        this.i13 = i13 ? i13 : null;
        this.i14 = i14 ? i14 : null;
        this.i15 = i15 ? i15 : null;
        this.i16 = i16 ? i16 : null;
        this.imaginet = imaginet ? imaginet : null;
        this.nuhsa = nuhsa ? nuhsa : null;
    }
}
