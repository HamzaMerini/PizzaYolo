export class Ingredient {
  public constructor(private _id?: number, private _libelle?: string, private _prixSupM?: number, private _prixSupL?: number, private _prixSupXL?: number, private _recettes[]?: Recette, private _typeIngredient?: string ) {}



  get id(): number | undefined {
    return this._id;
  }

  get libelle(): string | undefined {
    return this._libelle;
  }

  get prixSupM(): number | undefined {
    return this._prixSupM;
  }

  get prixSupL(): number | undefined {
    return this._prixSupM;
  }

  get prixSupXL(): number | undefined {
    return this._prixSupM;
  }

  get recettes(): Recette[] | undefined {
    return this._recettes;
  }

  get typeIngredient(): string | undefined {
    return this._typeIngredient;
  }

  set id(value: number | undefined) {
    this._id = value;
  }

  set libelle(value: string | undefined) {
    this._libelle= value;
  }

  set prixSupM(value: number | undefined) {
    this._prixSupM = value;
  }

  set prixSupL(value: number | undefined) {
    this._prixSupL = value;
  }

  set prixSupXL(value: number | undefined) {
    this._prixSupXL = value;
  }

  set recettes(value: Recette[] | undefined) {
    this._recettes = value;
  }

  set typeIngredient(value: string | undefined) {
    this._typeIngredient = value;
  }
  
}
